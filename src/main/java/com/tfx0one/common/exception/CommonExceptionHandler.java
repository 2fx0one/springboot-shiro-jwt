package com.tfx0one.common.exception;

/*
 * @Auth 2fx0one
 * 2019/3/13 00:35
 */

import com.tfx0one.common.api.R;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice
public class CommonExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(CommonException.class)
    @ResponseStatus
    public R handleCommonException(CommonException e) {
        return R.error(e.getCode(), e.getMsg());
    }

    //身份未认证
    @ExceptionHandler(UnauthenticatedException.class)
    public R handleUnauthenticatedException(UnauthenticatedException e) {
//        logger.error(e.getMessage(), e);
        return R.error(HttpStatus.FORBIDDEN.value(), "身份未认证");
    }

    //用户权限不足
    @ExceptionHandler(AuthorizationException.class)
    public R handleUnauthorizedException(AuthorizationException e) {
//        logger.error(e.getMessage(), e);
        return R.error(HttpStatus.UNAUTHORIZED.value(), "没有权限，请联系管理员授权");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error(HttpStatus.NOT_FOUND.value(), "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

    // 捕捉控制器的其他所有异常
    @ExceptionHandler({Exception.class})
    public R globalException(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error();
    }

}
