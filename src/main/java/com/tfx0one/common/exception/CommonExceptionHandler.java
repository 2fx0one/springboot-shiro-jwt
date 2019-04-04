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
    public ResponseEntity<ExceptionResult> handleCommonException(CommonException e) {
        return R.status(e.getExceptionEnum().getCode(), new ExceptionResult(e.getExceptionEnum()));
    }

    //身份未认证
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseEntity<ExceptionResult> handleUnauthenticatedException(HttpServletRequest request, UnauthenticatedException e) {
//        e.printStackTrace();
        return R.status(AUTHZ_NOT_ALLOW.getCode(), new ExceptionResult(AUTHZ_NOT_ALLOW));
    }

    //用户权限不足
    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<ExceptionResult> handleUnauthorizedException(HttpServletRequest request, AuthorizationException e) {
//        e.printStackTrace();
        return R.status(AUTHC_NOT_ALLOW.getCode(), new ExceptionResult(AUTHC_NOT_ALLOW));
    }

    // 捕捉控制器的其他所有异常
    @ExceptionHandler({Exception.class})
    public ResponseEntity globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
//        System.out.println(ex);
        return R.status(getStatus(request).value(), "系统错误：" + ex.getMessage());
    }
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}
