package com.tfx0one.common.exception;

/*
 * @Auth 2fx0one
 * 2019/3/13 00:35
 */

import com.tfx0one.common.api.ExceptionResult;
import com.tfx0one.common.api.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ExceptionResult> handleCommonException(CommonException e) {
        return R.status(e.getExceptionEnum().getCode(), new ExceptionResult(e.getExceptionEnum()));
    }

    // 捕捉控制器的其他所有异常
    @ExceptionHandler({Exception.class})
    public ResponseEntity globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return R.status(getStatus(request).value(), "系统错误：" + ex);
    }
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}
