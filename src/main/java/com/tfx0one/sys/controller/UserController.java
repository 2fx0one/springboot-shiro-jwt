package com.tfx0one.sys.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import com.tfx0one.sys.vo.ApiUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 2fx0one
 * @since 2019-01-24
 */
@RestController
@RequestMapping("/api/sys/user")
public class UserController extends BaseController {


    @Resource
    private UserService userService;

    @PostMapping("/list" )
    public R<List<User>> userList(@RequestBody ApiUser search) {
        IPage<User> a = userService.listBySearch();
        IPage p = userService.page(new Page<>(), new QueryWrapper<User>().eq("office_id", search.getOfficeId()));
        userService.page(new Page<>(), new LambdaQueryWrapper<User>().eq(User::getName, "abc"));
        return R.ok();
    }
}
