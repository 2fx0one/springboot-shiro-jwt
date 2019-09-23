package com.tfx0one.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.Query;
import com.tfx0one.common.validator.Assert;
import com.tfx0one.modules.sys.dao.SysRoleDao;
import com.tfx0one.modules.sys.entity.SysRoleEntity;

import com.tfx0one.modules.sys.service.SysRoleMenuService;
import com.tfx0one.modules.sys.service.SysRoleService;
import com.tfx0one.modules.sys.service.SysUserRoleService;
import com.tfx0one.modules.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public Pagination<SysRoleEntity> queryPage(Map<String, Object> params, SysRoleEntity sysRole) {
        String roleName = sysRole.getRoleName();//(String)  params.get("roleName");
        Long createUserId = sysRole.getCreateUserId();// (Long) params.get("createUserId");

        IPage<SysRoleEntity> page = this.page(
                Query.page(params),
                new LambdaQueryWrapper<SysRoleEntity>()
                        .like(StringUtils.isNotBlank(roleName), SysRoleEntity::getRoleName, roleName)
                        .eq(createUserId != null, SysRoleEntity::getCreateUserId, createUserId)
        );

        return Pagination.create(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRole(SysRoleEntity role) {
        role.setCreateTime(new Date());
        this.save(role);

        //检查权限是否越权
        checkPermission(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleEntity role) {
        this.updateById(role);

        //检查权限是否越权
        checkPermission(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] roleIds) {
        //删除角色
        this.removeByIds(Arrays.asList(roleIds));

        //删除角色与菜单关联
        sysRoleMenuService.deleteBatch(roleIds);

        //删除角色与用户关联
        sysUserRoleService.deleteBatch(roleIds);
    }


    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return baseMapper.queryRoleIdList(createUserId);
    }

    /**
     * 检查权限是否越权
     */
    private void checkPermission(SysRoleEntity role) {
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateUserId() == GlobalConstant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        Assert.isTrue(menuIdList.containsAll(role.getMenuIdList()), "新增角色的权限，已超出你的权限范围");
    }
}
