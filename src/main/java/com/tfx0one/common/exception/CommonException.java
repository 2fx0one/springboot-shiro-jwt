package com.tfx0one.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * @Auth 2fx0one
 * 2019/3/13 01:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommonException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}
