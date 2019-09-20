/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tfx0one.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.exception.CommonException;
import com.tfx0one.modules.app.dao.UserDao;
import com.tfx0one.modules.app.entity.UserEntity;
import com.tfx0one.modules.app.form.LoginForm;
import com.tfx0one.modules.app.service.UserService;

import com.tfx0one.common.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public UserEntity queryByMobile(String mobile) {
        return getOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getMobile, mobile));
//        return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
    }

    @Override
    public UserEntity login(LoginForm form) {
        UserEntity user = queryByMobile(form.getMobile());
        Assert.notNull(user, "手机号或密码错误");

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
            throw new CommonException("手机号或密码错误");
        }

        return user;
    }
}
