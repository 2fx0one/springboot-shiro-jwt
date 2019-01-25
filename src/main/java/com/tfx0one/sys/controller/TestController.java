package com.tfx0one.sys.controller;

import com.tfx0one.common.api.R;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/sys/test")
public class TestController {
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
        return R.ok("bbb");
    }


    @GetMapping("/d")
    @RequiresPermissions({"sys:dict:view"})
    public R d() {
        return R.ok("bbb");
    }

    @GetMapping("/z")
    @RequiresPermissions({"zzzz"})
    public R z() {
        return R.ok("zzz");
    }


}
