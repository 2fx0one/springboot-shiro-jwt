package com.tfx0one.sys.controller;


import com.tfx0one.common.api.R;
import com.tfx0one.common.base.BaseController;
import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.vo.response.ApiUserInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 2fx0one
 * @since 2019-03-28
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @GetMapping("/info")
    @RequiresAuthentication
    public R<ApiUserInfo> userInfo() {
        //用户角色信息 菜单 权限

        User user = ShiroUtils.getCurrentUser();
        AuthorizationInfo info = ShiroUtils.getAuthorizationInfo();

        return R.ok(ApiUserInfo.create(user, info));
    }

}
