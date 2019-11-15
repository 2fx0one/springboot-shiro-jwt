

package com.tfx0one.modules.app.controller;


import com.tfx0one.common.utils.R;
import com.tfx0one.common.validator.Assert;
import com.tfx0one.common.validator.ValidatorUtils;
import com.tfx0one.common.validator.group.AddGroup;
import com.tfx0one.modules.app.entity.UserEntity;
import com.tfx0one.modules.app.form.RegisterForm;
import com.tfx0one.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 注册
 */
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedissonClient redissonClient;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody @Validated RegisterForm form) {

        RLock lock = redissonClient.getLock(form.getMobile());

        try {
            lock.lock();

            UserEntity userEntity = userService.queryByMobile(form.getMobile());
            if (userEntity != null) {
                return R.error("用户已经存在！");
            }

            System.out.println(new Date());
            //表单校验
//        ValidatorUtils.validateEntity(form);

            UserEntity user = new UserEntity();
            user.setMobile(form.getMobile());
            user.setUsername(form.getMobile());
            user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
            user.setCreateTime(new Date());
            userService.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


        return R.ok();
    }
}
