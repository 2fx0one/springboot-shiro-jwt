package com.tfx0one.modules.sys.controller;

import com.tfx0one.common.annotation.SysLog;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.MapUtils;
import com.tfx0one.common.utils.R;
import com.tfx0one.common.validator.Assert;
import com.tfx0one.modules.sys.entity.SysMenuEntity;
import com.tfx0one.modules.sys.service.SysMenuService;
import com.tfx0one.modules.sys.service.SysUserService;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sys/menu")
@AllArgsConstructor
public class SysMenuController extends AbstractBaseController {

    private final SysMenuService sysMenuService;
    private final SysUserService sysUserService;

    /**
     * 导航菜单 不缓存。方便用户刷新使用新的菜单 缓存会增加逻辑复杂度。这个是后台用户使用。不需要过度使用缓存
     */
    @GetMapping("/nav")
    public R nav() {
        List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());

//        Collection<String> permissions = ShiroUtils.getAuthorizationInfo().getStringPermissions();

        Set<String> permissions = sysUserService.queryAllPerms(getUserId());
        return R.ok(MapUtils.create().put("menuList", menuList).put("permissions", permissions));
//        return R.ok(menuList.stream().map(ResponseSysMenu::create).collect(Collectors.toList()));
    }

    /**
     * 所有菜单列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public R list() {
        List<SysMenuEntity> menuList = sysMenuService.list();
//        for (SysMenuEntity sysMenuEntity : menuList) {
//            SysMenuEntity parentMenuEntity = sysMenuService.getById(sysMenuEntity.getParentId());
//            if (parentMenuEntity != null) {
//                sysMenuEntity.setParentName(parentMenuEntity.getName());
//            }
//        }

        return R.ok(menuList);
    }


    /**
     * 选择菜单(添加、修改菜单)
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public R select() {
        //查询列表数据
        List<SysMenuEntity> menuList = sysMenuService.queryNotButtonList();

        //添加顶级菜单
        SysMenuEntity root = new SysMenuEntity();
        root.setMenuId(0L);
        root.setName("一级菜单");
        root.setParentId(-1L);
        root.setOpen(true);
        menuList.add(root);

        return R.ok(menuList);
    }

    /**
     * 菜单信息
     */
    @GetMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenuEntity menu = sysMenuService.getById(menuId);
        return R.ok(menu);
    }

    /**
     * 保存
     */
    @SysLog("保存菜单")
    @PostMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public R save(@RequestBody SysMenuEntity menu) {
        //数据校验
        verifyForm(menu);

        sysMenuService.save(menu);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改菜单")
    @PostMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R update(@RequestBody SysMenuEntity menu) {
        //数据校验
        verifyForm(menu);

        sysMenuService.updateMenuById(menu);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除菜单")
    @PostMapping("/delete/{menuId}")
    @RequiresPermissions("sys:menu:delete")
    public R delete(@PathVariable("menuId") long menuId) {
        if (menuId <= 31) {
            return R.error("系统菜单，不能删除");
        }

        //判断是否有子菜单或按钮
        List<SysMenuEntity> menuList = sysMenuService.listByParentId(menuId);
        if (menuList.size() > 0) {
            return R.error("请先删除子菜单或按钮");
        }

        sysMenuService.delete(menuId);

        return R.ok();
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysMenuEntity menu) {
        Assert.notBlank(menu.getName(), "菜单名称不能为空");

        Assert.notNull(menu.getParentId(), "上级菜单不能为空");


        //菜单
        if (menu.getType() == GlobalConstant.MenuType.MENU.getValue()) {
            Assert.notBlank(menu.getPath(), "菜单PATH不能为空");
        }

        //如果不是父节点不是根节点，找到其父节点。
        if (menu.getParentId() != 0) {
            SysMenuEntity parentMenu = sysMenuService.getById(menu.getParentId());
            //上级菜单类型
            int parentType = parentMenu.getType();

            //当前操作的节点为 目录或菜单
            if (menu.getType() == GlobalConstant.MenuType.CATALOG.getValue() ||
                    menu.getType() == GlobalConstant.MenuType.MENU.getValue()) {

                Assert.isTrue(parentType == GlobalConstant.MenuType.CATALOG.getValue(), "上级菜单只能为目录类型");
                return;
            }

            //当前操作的节点为 按钮
            if (menu.getType() == GlobalConstant.MenuType.BUTTON.getValue()) {
                Assert.isTrue(parentType == GlobalConstant.MenuType.MENU.getValue(), "上级菜单只能为菜单类型");
                return;
            }
        }

    }
}
