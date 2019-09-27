

package com.tfx0one.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tfx0one.common.annotation.SysLog;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.R;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.validator.ValidatorUtils;
import com.tfx0one.modules.sys.entity.SysRoleEntity;
import com.tfx0one.modules.sys.service.SysRoleMenuService;
import com.tfx0one.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractBaseController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 角色列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R<Pagination<SysRoleEntity>> list(@RequestParam Map<String, Object> params, SysRoleEntity sysRole) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != GlobalConstant.SUPER_ADMIN) {
            sysRole.setCreateUserId(getUserId());
        }
        return R.ok(sysRoleService.queryPage(params, sysRole));
    }

    /**
     * 角色列表
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:role:select")
    public R<List<SysRoleEntity>> select() {

        List<SysRoleEntity> list = sysRoleService.list(
                Wrappers.<SysRoleEntity>lambdaQuery()
                        //如果不是超级管理员，则只查询自己所拥有的角色列表
                        .eq(getUserId() != GlobalConstant.SUPER_ADMIN, SysRoleEntity::getCreateUserId, getUserId())
        );

        return R.ok(list);
    }

    /**
     * 角色信息
     */
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity role = sysRoleService.getById(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);
        return R.ok(role);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@Validated @RequestBody SysRoleEntity role) {
//        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.saveRole(role);

        return R.ok();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@Validated @RequestBody SysRoleEntity role) {
//        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.update(role);

        return R.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);

        return R.ok();
    }
}
