package com.tfx0one.common;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionAdvice {
    // 捕捉shiro的异常 authc 401 未认证身份
    // https://stackoverflow.com/questions/3297048/403-forbidden-vs-401-unauthorized-http-responses?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({ShiroException.class})
    public R handleUnauthorized(ShiroException e) {
        return R.error(401, e.getMessage());
    }

    // 捕捉shiro的异常 authz 403 以认证身份，但权限不足
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({UnauthorizedException.class})
    public R handleShiro(UnauthorizedException e) {
        return R.error(403, e.getMessage());
    }

    // 捕捉其他所有异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public R globalException(HttpServletRequest request, Throwable ex) {
        return R.error(getStatus(request).value(), ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}