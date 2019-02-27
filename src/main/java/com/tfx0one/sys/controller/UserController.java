package com.tfx0one.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import com.tfx0one.sys.vo.ApiUser;
import org.springframework.web.bind.annotation.*;

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
    public R<List<User>> userList(@RequestBody ApiUser search, @RequestParam long pageNo, @RequestParam long pageSize) {
        User u = new User().setOfficeId(search.getOfficeId());
        IPage<User> page = userService.pageBy(u, pageNo, pageSize);

        return R.ok("ok", page.getRecords(), page);
    }
}
