package com.tfx0one.sys.service.impl;

import com.tfx0one.sys.entity.SysRole;
import com.tfx0one.sys.entity.SysUser;
import com.tfx0one.sys.mapper.SysRoleMapper;
import com.tfx0one.sys.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 2fx0one
 * @since 2019-06-20
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public List<SysRole> listByUserId(SysUser user) {
        return this.baseMapper.listByUserId(user);
    }
}
