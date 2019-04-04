package com.tfx0one.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.base.BaseEntity;
import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author 2fx0one
 * @since 2019-03-28
 */
@RestController
@RequestMapping("/api/sys/menu")
@RequiresAuthentication
@RequiresRoles({"admin"})
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @GetMapping("view")
    public ResponseEntity sysMenuView() {
        return R.ok(menuService.list());
    }

    @PostMapping("add")
    public ResponseEntity sysMenuAdd(@RequestBody Menu menu) {
        menuService.save(menu);
        return R.ok("添加成功！");
    }

    @PutMapping("modify")
    public ResponseEntity sysMenuModify(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return R.ok("修改成功！");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity sysMenuDelete(@PathVariable String id) {
        menuService.removeById(id);
        return R.ok("删除成功！");
    }
}
