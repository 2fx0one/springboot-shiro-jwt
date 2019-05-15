package com.tfx0one.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.JWTUtils;
import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.entity.Role;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.RoleService;
import com.tfx0one.sys.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ShiroAuthRealm extends AuthorizingRealm {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    /**
     * 认证信息(身份验证)
     * Authentication 是用来验证用户身份
     * <p>
     * 缓存KEY 使用的是 token.getPrincipal() == jwt_token。
     * AuthenticatingRealm::getAuthenticationCacheKey() -> return token != null ? token.getPrincipal() : null;
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("AUTH_C 认证信息(身份验证) ===> MyShiroRealm.doGetAuthenticationInfo()");
//        authenticationToken 实际是 JWTToken对象包装 在 executeLogin 中  getSubject(request, response).login(token); 传入
//        System.out.println(authenticationToken.getPrincipal());
//        String token = (String) authenticationToken.getPrincipal();
        String jwtToken = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(jwtToken);
        if (username == null) {
//            只能抛出 AuthenticationException
//            throw new CommonException(TOKEN_INVALID);
            throw new UnauthenticatedException("[用户不存在] token invalid");
        }

        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getLoginName, username));
        if (user == null) {
//            throw new CommonException(TOKEN_INVALID);
            throw new UnauthenticatedException("[用户不存在] User didn't existed!");
        }

        if (!JWTUtils.verify(jwtToken, username, user.getPassword())) {
            //产生 JWTVerificationException 抛出异常
//            throw new CommonException(TOKEN_INVALID);
            throw new UnauthenticatedException("[TOKEN 认证信息(身份验证) 认证失败] 请重新登录！");
        }


        //角色 菜单 也准备好 留给 接下来的 AUTHZ 阶段使用
        List<Role> roleList = roleService.listByUserId(user);
        List<Menu> userAllMenuList = roleList.stream()
                .map(Role::getMenuList).flatMap(Collection::stream).distinct().collect(Collectors.toList());

        //都绑定到角色上
        user.setRoleList(roleList);
        user.setMenuList(userAllMenuList);

        //token 也放缓存
        user.setJwtToken(jwtToken);

        return new SimpleAuthenticationInfo(user, jwtToken, getName());
    }


    /**
     * 此方法调用hasRole,hasPermission的时候才会进行回调.
     * <p>
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * <p>
     * <p>
     * 缓存KEY 使用的是 PrincipalCollection principals。
     * AuthorizingRealm::getAuthorizationCacheKey(PrincipalCollection principals) -> reuturn principals
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) { //也是key
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo 就只会执行一次了，
         * 缓存过期之后会再次执行。
         *
         * ！！ 主动调用 ShiroUtils.getAuthorizationInfo 也能触发权限并放入缓存
         */


        log.info("AUTH_Z 权限信息.(授权) ===> MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        User user = (User) principals.getPrimaryPrincipal();
        List<Role> roleList = user.getRoleList();

        //角色字符串
        List<String> roles = roleList.stream().map(Role::getRoleType).collect(Collectors.toList());
        simpleAuthorizationInfo.addRoles(roles);

        //权限字符串
        Set<String> permissions = user.getMenuList().stream()
//                .map(Role::getMenuList).flatMap(Collection::stream)
                .map(Menu::getPermission).filter(StringUtils::isNotEmpty) //过滤空
                .flatMap(s -> Arrays.stream(s.split(GlobalConstant.SPLIT_DELIMETER)))
//                .sorted()
                .collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    // AUTH_C 权限缓存 key 使用jwtToken 在logout时，需要 doClearCache 清除身份认证的缓存。但是默认的Key是principal 但是登录的时候缓存的Key是 jwtToken
    @Override
    protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
        return ((User) principals.getPrimaryPrincipal()).getJwtToken();
//        return getAvailablePrincipal(principals);
    }

    // AUTH_Z 权限缓存 key 使用jwtToken
    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        return ((User) principals.getPrimaryPrincipal()).getJwtToken();
    }

    //方便外部调用 获取该用户的权限
    @Override
    public AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        return super.getAuthorizationInfo(principals);
    }

    //方便外部调用 清理该用户的认证和权限
    @Override
    public void doClearCache(PrincipalCollection principals) {
        super.doClearCache(principals);
    }
}
