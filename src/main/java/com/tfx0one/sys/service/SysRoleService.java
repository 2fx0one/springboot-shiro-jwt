package com.tfx0one.sys.service;

import com.tfx0one.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.sys.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-06-20
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> listByUserId(SysUser user);
}
