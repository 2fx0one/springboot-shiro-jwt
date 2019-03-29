package com.tfx0one.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/*
 * @Auth 2fx0one
 * 2019/3/13 01:05
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    TOKEN_INVALID(50014, "Token 失效，请重新登录！"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "请求错误！"),

    //401 和 403 区别 https://stackoverflow.com/questions/3297048/403-forbidden-vs-401-unauthorized-http-responses?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
//    AUTHZ_NOT_ALLOW(HttpStatus.UNAUTHORIZED.value(), "身份未认证"),
//    AUTHC_NOT_ALLOW(HttpStatus.FORBIDDEN.value(), "权限不足"), //已认证身份，但权限不足

    LOGIN_USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "用户名或密码错误！"),
    ;
    private int code;
    private String msg;

}
