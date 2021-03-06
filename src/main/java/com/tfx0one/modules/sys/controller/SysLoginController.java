package com.tfx0one.modules.sys.controller;

import com.tfx0one.common.utils.JWTUtils;
import com.tfx0one.common.utils.R;
import com.tfx0one.modules.sys.shiro.ShiroUtils;
import com.tfx0one.common.validator.Assert;
import com.tfx0one.common.validator.ValidatorUtils;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.SysCaptchaService;
import com.tfx0one.modules.sys.service.SysUserService;
import com.tfx0one.modules.sys.vo.RequestSysLogin;
import com.tfx0one.modules.sys.vo.ResponseSysLoginToken;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class SysLoginController extends AbstractBaseController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @PostMapping("/sys/login")
    @ApiOperation("登录")
    public R login(@Validated @RequestBody RequestSysLogin form) {
//        ValidatorUtils.validateEntity(form);

        //暂时不要验证码
//		boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
//		if(!captcha){
//			return R.error("验证码不正确");
//		}

        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());

        //账号不存在
        Assert.isTrue(user != null, "用户不存在！");

        // 密码错误
        if (!user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        return R.ok(ResponseSysLoginToken.create(JWTUtils.sign(user)));
    }


    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public R logout() {

        ShiroUtils.logout();
//		sysUserTokenService.logout(getUserId());
        return R.ok();
    }

}
