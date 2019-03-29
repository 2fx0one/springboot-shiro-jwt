package com.tfx0one.sys.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: springboot-shiro-jwt
 * @author: wangk
 * @date: 2019/3/29 11:43
 * @Version: 1.0
 */
@ApiModel("菜单")
@Data
@Accessors(chain = true)
public class APIRouteMeta {
    private String title;
    private String icon;
    private Boolean noCache = true;
}
