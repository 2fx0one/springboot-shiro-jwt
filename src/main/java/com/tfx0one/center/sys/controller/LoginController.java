package com.tfx0one.center.sys.controller;

import com.tfx0one.center.sys.model.SysUser;
import com.tfx0one.center.sys.service.SysUserService;
import com.tfx0one.center.sys.vo.RequestUserLogin;
import com.tfx0one.center.sys.vo.ResponseUserInfo;
import com.tfx0one.center.sys.vo.ResponseUserLogin;
import com.tfx0one.common.api.R;
import com.tfx0one.common.constant.APIConstant;
import com.tfx0one.common.sceurity.JWTUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author : 2fx0one
 * @date : 2018/11/7 09:34
 */

@RestController
public class LoginController {

    @Resource
    SysUserService sysUserService;

//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public R index() {
//        return R.ok("index");
//    }

    @ApiOperation("管理后台网页登录")
    @RequestMapping(path = APIConstant.authSysUserLogin, method = RequestMethod.POST)
    public R sysUserlogin(@RequestBody RequestUserLogin login) {
        //验证用户
        SysUser sysUser = sysUserService.login(login.getUsername(), login.getPassword());

        //登录完成。生成token
        final String token = JWTUtils.generateToken(sysUser.getId(), sysUser.getUsername(), Collections.emptyList());

        System.out.println("token =  " + token);

        return R.ok("success 登录成功!", ResponseUserLogin.create(sysUser, token));
    }


    @RequestMapping(path = APIConstant.authSysUserInfo, method = RequestMethod.POST)
    @ApiOperation("管理后台网页登录的用户信息 菜单信息")
    public R<ResponseUserInfo> sysUserInfo() {
        return R.ok();
    }
}
