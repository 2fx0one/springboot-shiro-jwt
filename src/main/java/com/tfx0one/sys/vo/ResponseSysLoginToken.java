package com.tfx0one.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseSysLoginToken {
    private String token;

    public static ResponseSysLoginToken create(String sign) {
        return new ResponseSysLoginToken().setToken(sign);
    }
}
