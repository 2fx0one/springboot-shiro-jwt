package com.tfx0one.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseEntity;
import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.service.MenuService;
import com.tfx0one.sys.vo.response.ApiMenu;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.tfx0one.common.base.BaseController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@RestController
@RequiresAuthentication
@RequestMapping("/api/sys/menu")
public class MenuController extends BaseController {

    @Resource
    private MenuService menuService;

    @GetMapping("list")
    @RequiresPermissions({"sys:menu:view"})
    public R<List<ApiMenu>> menuList() {
        List<Menu> menuList = menuService.list();
        return R.ok("ok", menuList.stream().map(ApiMenu::create).collect(Collectors.toList()));
    }

    @PostMapping("add")
    @RequiresPermissions({"sys:menu:add"})
    public R menuAdd(@RequestBody ApiMenu add) {
        if (add.getId() == null) {
            return R.error("添加时 id 必须为空");
        }
        Menu m = add.entity();
        menuService.save(m);
        return R.ok();
    }

    @PostMapping("modify")
    @RequiresPermissions({"sys:menu:modify"})
    public R menumodify(@RequestBody ApiMenu modify) {
        if (modify.getId() == null) {
            return R.error("修改时 id 不能为空");
        }
        Menu m = modify.entity();
        menuService.updateById(m);
        return R.ok();
    }
}
