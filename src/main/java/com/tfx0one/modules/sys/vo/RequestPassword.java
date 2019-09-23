package com.tfx0one.modules.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 密码表单
 *
 */
@Data
public class RequestPassword {
    /**
     * 原密码
     */
    @NotBlank(message="原密码不能为空")
    private String password;
    /**
     * 新密码
     */
    @NotBlank(message="新密码不能为空")
    private String newPassword;

}
