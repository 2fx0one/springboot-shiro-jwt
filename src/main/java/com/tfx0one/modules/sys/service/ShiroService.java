package com.tfx0one.modules.sys.service;


import com.tfx0one.modules.sys.entity.SysUserEntity;

import java.util.Set;

/**
 * shiro相关接口
 *
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUserById(Long userId);
}
