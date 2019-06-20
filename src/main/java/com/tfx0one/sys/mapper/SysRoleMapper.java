package com.tfx0one.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfx0one.sys.entity.SysRole;
import com.tfx0one.sys.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 2fx0one
 * @since 2019-06-20
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> listByUserId(SysUser user);
}
