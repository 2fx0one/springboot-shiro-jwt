

package com.tfx0one.modules.app.controller;


import com.tfx0one.common.utils.JWTUtils;
import com.tfx0one.common.utils.R;
import com.tfx0one.common.validator.ValidatorUtils;
import com.tfx0one.modules.app.entity.UserEntity;
import com.tfx0one.modules.app.form.LoginForm;
import com.tfx0one.modules.app.service.UserService;
import com.tfx0one.modules.app.utils.AppJWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 */
@RestController
@RequestMapping("/app")
@Api("APP登录接口")
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AppJWTUtils appJwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        UserEntity loginUser = userService.login(form);

        //生成token
//        String token = JWTUtils.sign(loginUser);
        String token = appJwtUtils.generateToken(loginUser.getUserId());


        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", appJwtUtils.getExpire());

        return R.ok(map);
    }

}
