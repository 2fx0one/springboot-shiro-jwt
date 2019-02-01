package com.tfx0one.sys.controller;

import com.tfx0one.common.api.R;
import com.tfx0one.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
public class TestController {

//    @Resource
//    private CacheManager cacheManager;
//    private EhCacheManager ehCacheManager;

    @GetMapping("/a")
    public R a() {
        return R.ok("aaa");
    }

    @GetMapping("/b")
    public R b() {
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
