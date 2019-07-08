/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.tfx0one.modules.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录表单
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class RequestSysLogin {

    @NotBlank(message="用户名不能为空")
    private String username;
    @NotBlank(message="密码不能为空")
    private String password;
    private String captcha;
    private String uuid;


}
