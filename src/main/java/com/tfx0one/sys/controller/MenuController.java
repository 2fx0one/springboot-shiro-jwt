package com.tfx0one.sys.controller;


import com.tfx0one.common.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//    @Autowired
//    private MenuService menuService;
//
//    @GetMapping("view")
//    public R<List<Menu>> sysMenuView() {
//        return R.ok(menuService.list());
//    }
//
//    @PostMapping("add")
//    public R sysMenuAdd(@RequestBody Menu menu) {
//        menuService.save(menu);
//        return R.ok("添加成功！");
//    }
//
//    @PutMapping("modify")
//    public R sysMenuModify(@RequestBody Menu menu) {
//        menuService.updateById(menu);
//        return R.ok("修改成功！");
//    }
//
//    @DeleteMapping("delete/{id}")
//    public R sysMenuDelete(@PathVariable String id) {
//        menuService.removeById(id);
//        return R.ok("删除成功！");
//    }
}
