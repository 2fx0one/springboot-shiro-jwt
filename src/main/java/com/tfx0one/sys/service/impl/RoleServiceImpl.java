package com.tfx0one.sys.service.impl;

import com.tfx0one.sys.entity.Role;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.mapper.RoleMapper;
import com.tfx0one.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<Role> listByUserId(User user) {
        return baseMapper.listByUserId(user);
    }
}
