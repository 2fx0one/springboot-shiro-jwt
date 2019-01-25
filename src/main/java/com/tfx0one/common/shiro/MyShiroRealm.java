package com.tfx0one.common.shiro;

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
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class MyShiroRealm extends AuthorizingRealm {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 认证信息(身份验证)
     * Authentication 是用来验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("认证信息(身份验证) ===> MyShiroRealm.doGetAuthenticationInfo()");
//        System.out.println(authenticationToken.getPrincipal());
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("[用户不存在] token invalid");
        }

        User user = userService.getByLoginName(username);
        if (user == null) {
            throw new AuthenticationException("[用户不存在] User didn't existed!");
        }

        if(!JWTUtils.verify(token, username, user.getPassword())) {
            //产生 JWTVerificationException 抛出异常
            throw new AuthenticationException("[TOKEN 认证信息(身份验证) 认证失败] 请重新登录！");
        }

        return new SimpleAuthenticationInfo(user, token, getName());
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
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo 就只会执行一次了，
         * 缓存过期之后会再次执行。
         */
        log.info("权限信息.(授权) ===> MyShiroRealm.doGetAuthorizationInfo()");
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roleList = roleService.listByUserId(user);

        //角色
        List<String> roles = roleList.stream().map(Role::getEnname).collect(Collectors.toList());
        simpleAuthorizationInfo.addRoles(roles);

        //权限
        List<String> permissions = roleList.stream()
                .map(Role::getMenuList).flatMap(Collection::stream)
                .map(Menu::getPermission).filter(StringUtils::isNotEmpty) //过滤空
                .flatMap(s -> Arrays.stream(s.split(GlobalConstant.SPLIT_DELIMETER)))
                .sorted()
                .collect(Collectors.toList());
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }
}
