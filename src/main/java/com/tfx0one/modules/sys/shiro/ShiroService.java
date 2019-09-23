package com.tfx0one.modules.sys.shiro;

import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShiroService {
    @Autowired
    private SysUserService sysUserService;


    public Set<String> getUserPermissions(Long userId) {
        //用户权限列表
        return sysUserService.queryAllPerms(userId);
    }


    public SysUserEntity queryUserById(Long userId) {
        return sysUserService.getById(userId);
    }
}
