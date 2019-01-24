package com.tfx0one.sys.controller;


import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.util.JWTUtil;
import com.tfx0one.common.util.ShiroUtil;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/a")
    @RequiresAuthentication
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
