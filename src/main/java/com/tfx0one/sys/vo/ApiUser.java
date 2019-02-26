package com.tfx0one.sys.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/*
 * @Auth 2fx0one
 * 2019/2/26 21:31
 */
@ApiModel("用户")
@Data
@Accessors(chain = true)
public class ApiUser {
    private String officeId;
}
