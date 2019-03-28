package com.tfx0one.common;

import com.tfx0one.common.api.R;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionAdvice {
    //401 和 403 区别 https://stackoverflow.com/questions/3297048/403-forbidden-vs-401-unauthorized-http-responses?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    // 捕捉shiro的异常 authc 401 身份未认证
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthenticatedException.class})
    public R handleUnauthenticatedException(ShiroException e) {
        return R.error(401, "身份未认证" + e.getMessage());
    }
//    UnauthenticatedException

    // 捕捉shiro的异常 authz 403 已认证身份，但权限不足
//    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({UnauthorizedException.class})
    public R handleUnauthorizedException(UnauthorizedException e) {
        return R.error(403, "权限不足" + e.getMessage());
    }

    // 捕捉其他的 shiro 的异常
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ShiroException.class})
    public R handleShiroException(ShiroException e) {
        return R.error(400, e.getMessage());
    }

    // 捕捉其他所有异常
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public R globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return R.error(getStatus(request).value(), "系统错误：" + ex);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}