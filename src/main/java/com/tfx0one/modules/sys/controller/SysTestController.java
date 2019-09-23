package com.tfx0one.modules.sys.controller;

import com.tfx0one.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/test")
//@RequiresAuthentication
public class SysTestController extends AbstractBaseController {

    @GetMapping("/a")
    @RequiresPermissions("sys:user:delete")
    @ApiOperation(value = "a")
    public R a() {
        return R.ok(getUser());
    }

    @GetMapping("/b")
    @ApiOperation(value = "b")
    public R b() {
        return R.ok("bbbbb");
    }

    @GetMapping("/c")
    @ApiOperation(value = "c")
    public R c() {
        return R.ok("ccccc");
    }
}
