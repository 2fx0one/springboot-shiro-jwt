package com.tfx0one.center.sys.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 2fx0one
 * @date : 2018/11/7 11:42
 */
@ApiModel("登陆信息")
@Data
public class RequestUserLogin {
    @ApiModelProperty(value = "用户名", required = true, position = 1) //required = false 前台显示为可选 optional
    private String username;

    @ApiModelProperty(value = "密码", required = true, position = 2)
    private String password;
}
