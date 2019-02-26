package com.tfx0one.sys.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * @Auth 2fx0one
 * 2019/2/26 20:18
 */
@ApiModel("登录账号密码")
@Data
public class ApiLoginUser {
    @ApiModelProperty(value = "用户名", required = true, position = 1) //required = false 前台显示为可选 optional
    private String username;

    @ApiModelProperty(value = "密码", required = true, position = 2)
    private String password;
}