package com.tfx0one.common.exception;

/*
 * @Auth 2fx0one
 * 2019/3/13 00:35
 */

import com.tfx0one.common.api.ExceptionResult;
import com.tfx0one.common.api.R;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static com.tfx0one.common.exception.ExceptionEnum.AUTHC_NOT_ALLOW;
import static com.tfx0one.common.exception.ExceptionEnum.AUTHZ_NOT_ALLOW;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public R handleCommonException(CommonException e) {
        return R.error(HttpStatus.BAD_REQUEST.value(), "请求错误！");
    }

    //身份未认证
    @ExceptionHandler(UnauthenticatedException.class)
    public R handleUnauthenticatedException(HttpServletRequest request, UnauthenticatedException e) {
//        e.printStackTrace();
        return R.error(AUTHZ_NOT_ALLOW.getCode(), "身份未认证");
    }

    //用户权限不足
    @ExceptionHandler(AuthorizationException.class)
    public R handleUnauthorizedException(HttpServletRequest request, AuthorizationException e) {
//        e.printStackTrace();
        return R.error(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误！");
    }

    // 捕捉控制器的其他所有异常
    @ExceptionHandler({Exception.class})
    public R globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统错误：" + ex.getMessage());
//        System.out.println(ex);
//        return R.status(getStatus(request).value(), "系统错误：" + ex.getMessage());
    }
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }


}
