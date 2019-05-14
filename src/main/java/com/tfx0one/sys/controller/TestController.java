package com.tfx0one.sys.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: base-web
 * @author: wangk
 * @date: 2019/1/25 13:40
 * @Version: 1.0
 */

@RestController
@RequiresAuthentication
@RequestMapping("/api/sys/test")
public class TestController extends BaseController {

//    @Resource
//    private CacheManager cacheManager;
//    private EhCacheManager ehCacheManager;

    @Autowired
    private MenuService menuService;

    @GetMapping("/a")
    public R a() {
//        menuService.updateById(new Menu().setId("15").setDelFlag("1"));
        menuService.update(new LambdaUpdateWrapper<Menu>().set(Menu::getDelFlag, "0").eq(Menu::getId, "15"));
        return R.ok("aaa");
    }

    @GetMapping("/b")
    public R b() {
        menuService.save(new Menu().setComponent("a").setParentId("0").setParentIds("1").setName("a").setSort(1));
        return R.ok("bbb");
    }

    @GetMapping("/c")
    @RequiresPermissions({"sys:dict:view"})
    public R c() {
        ShiroUtils.clearCurrentUserAuthorization();
//        ShiroUtils.clearAllUserAuthorization();
//        Subject s = ShiroUtils.getSubject();
//        Object o1 = s.getPrincipal();
//        System.out.println(o1);
//        System.out.println(s.getPrincipals());
//        System.out.println(cacheManager.getCache("shiroAuthz").get("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDg0MjYxMDksInVzZXJuYW1lIjoidGhpbmtnZW0ifQ.nKa-m6VZUANFYsF5KrjW28PH0zyCzqw7qw35bPM3GFU"));
//        System.out.println(cacheManager.getCache("shiroAuthz").get(s.getPrincipals()));
//        cacheManager.getCache("shiroAuthz").clear();
        return R.ok("ccc");
    }


    @GetMapping("/d")
    @RequiresPermissions({"sys:dict:view"})
    public R d() {
        return R.ok("ddd");
    }

    @GetMapping("/z")
    @RequiresPermissions({"zzzz"})
    public R z() {
        return R.ok("zzz");
    }


}
