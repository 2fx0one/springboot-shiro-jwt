package com.tfx0one.sys.controller;

import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/app/")
public class TestAppController extends BaseController {



    @GetMapping("/a")
    public R a() {
        return R.ok("aaa");
    }


}
