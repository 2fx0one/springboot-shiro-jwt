package com.tfx0one.sys.mapper;

import com.tfx0one.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfx0one.sys.entity.User;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> listByUserId(User user);
}
