package com.tfx0one.sys.controller;

import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.util.JWTUtil;
import com.tfx0one.common.util.ShiroUtil;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @projectName: base-web
 * @author: wangk
 * @date: 2019/1/24 17:39
 * @Version: 1.0
 */

@RestController
public class LoginController extends BaseController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public R login(@RequestParam String username, @RequestParam String password) {
        User user = userService.getByLoginName(username);
        String salt = user.getId();
        String simpleHashPassword = ShiroUtil.md5(password, salt);
        if (user.getPassword().equals(simpleHashPassword)) {
            return R.ok("login success!", JWTUtil.sign(user));
        } else {
            throw new AuthenticationException("账号或密码错误！");
        }
    }

}
