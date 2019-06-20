package com.tfx0one.sys.controller;


import com.tfx0one.common.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author 2fx0one
 * @since 2019-03-28
 */
@RestController
@RequestMapping("/api/sys/role")
@RequiresAuthentication
@RequiresRoles({"admin"})
public class RoleController extends BaseController {
//    @Autowired
//    private RoleService roleService;
//
//    @GetMapping("view")
//    public R sysMenuView() {
//        return R.ok(roleService.list());
//    }
//
//    @PostMapping("add")
//    public R sysMenuAdd(@RequestBody Role role) {
//        roleService.save(role);
//        return R.ok("添加成功！");
//    }
//
//    @PutMapping("modify")
//    public R sysMenuModify(@RequestBody Role role) {
//        roleService.updateById(role);
//        return R.ok("修改成功！");
//    }
//
//    @DeleteMapping("delete/{id}")
//    public R sysMenuDelete(@PathVariable String id) {
//        roleService.removeById(id);
//        return R.ok("删除成功！");
//    }
}
