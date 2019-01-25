package com.tfx0one.sys.controller;

import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.util.JWTUtil;
import com.tfx0one.common.util.ShiroUtil;
import com.tfx0one.sys.entity.Role;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.RoleService;
import com.tfx0one.sys.service.UserService;
import com.tfx0one.sys.vo.ApiRequestLoginUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: base-web
 * @author: wangk
 * @date: 2019/1/24 17:39
 * @Version: 1.0
 */

@RestController
@RequestMapping("/sys/auth")
public class AuthController extends BaseController {

    @Resource
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @PostMapping("/login")
    public R login(@RequestBody ApiRequestLoginUser login) {
        User user = userService.getByLoginName(login.getUsername());
        if (user == null) {
            return R.error(401, "用户不存在");
        }
        String salt = user.getId();
        String simpleHashPassword = ShiroUtil.md5(login.getPassword(), salt);
        if (user.getPassword().equals(simpleHashPassword)) {
            return R.ok("login success!", JWTUtil.sign(user));
        } else {
            throw new AuthenticationException("账号或密码错误！");
        }
    }

    @GetMapping("/user/info")
    public R userInfo() {
        //用户角色信息 菜单 权限
        User user = ShiroUtil.getCurrentUser();
        List<Role> roles = roleService.listByUserId(user);
        return R.ok("success");
    }


}
