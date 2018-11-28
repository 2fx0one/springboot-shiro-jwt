package com.tfx0one.center.sys.vo;

import com.tfx0one.center.sys.model.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 2fx0one on 2018/6/30.
 */
@ApiModel("后台用户登录信息")
@Data
public class ResponseUserLogin {
    @ApiModelProperty(value = "用户 token", required = true, position = 1)
    private String token;

    @ApiModelProperty(value = "用户名", required = true, position = 2)
    private String username;

    @ApiModelProperty(value = "用户ID", required = true, position = 3)
    private String userId;

//    @ApiModelProperty(value = "用户ID", required = true, position = 5)
//    private Byte accountType;

    public static ResponseUserLogin create(SysUser sysUser, String token) {
        ResponseUserLogin self = new ResponseUserLogin();
        self.setUserId(sysUser.getId());
        self.setUsername(sysUser.getUsername());
        self.setToken(token);
//        self.setAccountType(sysUser.getAccountType());
        return self;
    }
}
