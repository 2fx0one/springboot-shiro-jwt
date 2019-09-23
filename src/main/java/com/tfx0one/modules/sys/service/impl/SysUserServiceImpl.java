package com.tfx0one.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.Query;
import com.tfx0one.common.validator.Assert;
import com.tfx0one.modules.sys.dao.SysUserDao;
import com.tfx0one.modules.sys.entity.SysMenuEntity;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.SysMenuService;
import com.tfx0one.modules.sys.service.SysRoleService;
import com.tfx0one.modules.sys.service.SysUserRoleService;
import com.tfx0one.modules.sys.service.SysUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 系统用户
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public Pagination<SysUserEntity> queryPage(Map<String, Object> params, SysUserEntity sysUser) {
        String username = sysUser.getUsername();// (String) params.get("username");
        Long createUserId = sysUser.getCreateUserId();// (Long) params.get("createUserId");

        IPage<SysUserEntity> page = this.page(
                Query.page(params),
                Wrappers.<SysUserEntity>lambdaQuery()
                        .like(StringUtils.isNotBlank(username), SysUserEntity::getUsername, username)
                        .eq(createUserId != null, SysUserEntity::getCreateUserId, createUserId)
        );

        return Pagination.create(page);
    }

    @Override
    public Set<String> queryAllPerms(Long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if (userId == GlobalConstant.SUPER_ADMIN) {
            List<SysMenuEntity> menuList = sysMenuService.list();
            permsList = menuList.stream().map(SysMenuEntity::getPerms).collect(Collectors.toList());
        } else {
            permsList = baseMapper.queryAllPerms(userId);
        }

        //用户权限列表
        return permsList.stream().filter(Objects::nonNull).flatMap(s -> Arrays.stream(s.split(","))).collect(Collectors.toSet());
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return baseMapper.queryAllMenuId(userId);
    }

    @Override
    public SysUserEntity queryByUserName(String username) {
        return this.getOne(Wrappers.<SysUserEntity>lambdaQuery().eq(SysUserEntity::getUsername, username));
    }

    @Override
    @Transactional
    public void saveUser(SysUserEntity user) {
        user.setCreateTime(new Date());
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        user.setSalt(salt);
        this.save(user);

        //检查角色是否越权
        checkRole(user);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional
    public void update(SysUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        this.updateById(user);

        //检查角色是否越权
        checkRole(user);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    public void deleteBatch(Long[] userId) {
        this.removeByIds(Arrays.asList(userId));
    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(
                userEntity,
                Wrappers.<SysUserEntity>lambdaUpdate().eq(SysUserEntity::getUserId, userId).eq(SysUserEntity::getPassword, password)
        );
    }

    /**
     * 检查角色是否越权
     */
    private void checkRole(SysUserEntity user) {
        if (user.getRoleIdList() == null || user.getRoleIdList().size() == 0) {
            return;
        }
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        if (user.getCreateUserId() == GlobalConstant.SUPER_ADMIN) {
            return;
        }

        //查询用户创建的角色列表
        List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());

        //判断是否越权
        Assert.isTrue(roleIdList.containsAll(user.getRoleIdList()), "新增用户所选角色，不是本人创建");
    }
}