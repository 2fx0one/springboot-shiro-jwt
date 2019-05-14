package com.tfx0one.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * @Auth 2fx0one
 * 2019/3/13 01:04
 */
@Getter
public class CommonException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CommonException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CommonException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CommonException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}
