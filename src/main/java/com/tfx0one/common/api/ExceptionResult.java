package com.tfx0one.common.api;

import com.tfx0one.common.exception.ExceptionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*
 * @Auth 2fx0one
 * 2019/3/13 01:10
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
