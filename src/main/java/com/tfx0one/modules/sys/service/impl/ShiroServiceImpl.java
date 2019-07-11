/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tfx0one.modules.sys.service.impl;

import com.tfx0one.common.constant.Constant;
import com.tfx0one.modules.sys.entity.SysMenuEntity;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.ShiroService;
import com.tfx0one.modules.sys.service.SysMenuService;
import com.tfx0one.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserService sysUserService;


    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            List<SysMenuEntity> menuList = sysMenuService.list();
            permsList = menuList.stream().map(SysMenuEntity::getPerms).collect(Collectors.toList());
        } else {
            permsList = sysUserService.queryAllPerms(userId);
        }

        //用户权限列表
        return permsList.stream().filter(Objects::nonNull).flatMap(s -> Arrays.stream(s.split(","))).collect(Collectors.toSet());
    }


    @Override
    public SysUserEntity queryUserById(Long userId) {
        return sysUserService.getById(userId);
    }
}
