package com.tfx0one.sys.controller;

import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.utils.JWTUtils;
import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.entity.Role;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import com.tfx0one.sys.vo.request.ApiLoginUser;
import com.tfx0one.sys.vo.response.ApiUserInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName: base-web
 * @author: wangk
 * @date: 2019/1/24 17:39
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api/sys/auth")
public class AuthController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody ApiLoginUser login) {
        User user = userService.getByLoginName(login.getUsername());
        if (user == null) {
            return R.error(401, "用户不存在");
        }
        String salt = user.getId();
        String simpleHashPassword = ShiroUtils.md5(login.getPassword(), salt);
        if (user.getPassword().equals(simpleHashPassword)) {
            return R.ok("login success!", JWTUtils.sign(user));
        } else {
            return R.error(401, "账号或密码错误！");
        }
    }

    @PostMapping("/logout")
    @RequiresAuthentication
    public R logout() {
        //jwtToken 并未失效 要等过期之后了。故而前端逻辑需要把jwtToken删除
        ShiroUtils.getSubject().logout();
        return R.ok("logout success");
    }

    @GetMapping("/user/info")
    @RequiresAuthentication
    public R<ApiUserInfo> userInfo() {
        //用户角色信息 菜单 权限
        List<Role> roleList = ShiroUtils.getCurrentUser().getRoleList();
        List<Menu> menuList = ShiroUtils.getCurrentUser().getMenuList();
        AuthorizationInfo info = ShiroUtils.getAuthorizationInfo();

        return R.ok("success",
                ApiUserInfo.create(
                        roleList,
                        menuList,
                        info.getStringPermissions()));
    }


}
