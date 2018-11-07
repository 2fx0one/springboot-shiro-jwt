package com.tfx0one.center.sys.service;

import com.tfx0one.center.sys.model.SysUser;

/**
 * @author : 2fx0one
 * @date : 2018/11/7 11:11
 */
public interface SysUserService {
    SysUser getUserByUsername(String username);

    SysUser login(String username, String password);
}
