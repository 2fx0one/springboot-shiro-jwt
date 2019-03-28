package com.tfx0one.sys.service;

import com.tfx0one.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.sys.entity.User;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-03-28
 */
public interface RoleService extends IService<Role> {

    List<Role> listByUserId(User user);
}
