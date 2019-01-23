package com.tfx0one.sys.controller;


import com.tfx0one.common.api.R;
import com.tfx0one.common.util.JWTUtil;
import com.tfx0one.sys.User;
import com.tfx0one.sys.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tfx0one.common.base.BaseController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author kelvin
 * @since 2019-01-23
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public R login(@RequestParam String username, @RequestParam String password) {
        User u = userService.getByUsername(username);
        if (u.getPassword().equals(password)) {
            return R.ok("login success!", JWTUtil.sign(username, password));
        } else {
            throw new AuthenticationException("账号或密码错误");
        }

    }

    @GetMapping("/a")
    @RequiresPermissions(value = {"user:list:view", "user:list:edit"})
    public R a() {
        return R.ok("success");
    }


    @GetMapping("/b")
    @RequiresPermissions(value = {"user:list:view", "user:list:edit"}, logical = Logical.OR)
    public R b() {
        return R.ok("success");
    }
}
