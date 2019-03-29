package com.tfx0one.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tfx0one.common.api.R;
import com.tfx0one.common.exception.CommonException;
import com.tfx0one.common.utils.JWTUtils;
import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.User;
import com.tfx0one.sys.service.UserService;
import com.tfx0one.sys.vo.request.ApiLoginUser;
import com.tfx0one.sys.vo.response.ApiUserInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.tfx0one.common.exception.ExceptionEnum.NOT_FOUND;


/**
 * @projectName: base-web
 * @author: wangk
 * @date: 2019/1/24 17:39
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api/sys/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody ApiLoginUser login) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getLoginName, login.getUsername()));
        if (user == null) {
            throw new CommonException(NOT_FOUND);
        }
        String salt = user.getId();
        String simpleHashPassword = ShiroUtils.md5(login.getPassword(), salt);
        if (!user.getPassword().equals(simpleHashPassword)) {
            throw new CommonException(NOT_FOUND);
        }
        return R.ok(JWTUtils.sign(user));
    }

    @PostMapping("/logout")
    @RequiresAuthentication
    public ResponseEntity logout() {
        //jwtToken 并未失效 要等过期之后了。故而前端逻辑需要配合把jwtToken删除
        ShiroUtils.getSubject().logout();
        return R.ok("logout success");
    }

    @GetMapping("/user/info")
    @RequiresAuthentication
    public ResponseEntity<ApiUserInfo> userInfo() {
        //用户角色信息 菜单 权限

        User user = ShiroUtils.getCurrentUser();
        AuthorizationInfo info = ShiroUtils.getAuthorizationInfo();

        return R.ok(ApiUserInfo.create(user, info));
    }


}
