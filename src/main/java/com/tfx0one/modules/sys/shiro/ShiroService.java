package com.tfx0one.modules.sys.shiro;

import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author wangk
 * @Description package-private 权限  不希望其他包使用
 * @Date  2019-09-23 17:07
 * @Param 
 * @return 
 **/
@Service
@AllArgsConstructor
public class ShiroService {
    private final SysUserService sysUserService;

    //用户权限列表
    Set<String> getUserPermissions(Long userId) {
        return sysUserService.queryAllPerms(userId);
    }


    SysUserEntity queryUserById(Long userId) {
        return sysUserService.getById(userId);
    }
}
