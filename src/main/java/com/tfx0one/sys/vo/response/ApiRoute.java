package com.tfx0one.sys.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tfx0one.sys.entity.Menu;
import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @projectName: springboot-shiro-jwt
 * @author: wangk
 * @date: 2019/3/29 11:41
 * @Version: 1.0
 */
@ApiModel("路由")
@Data
@Accessors(chain = true)
public class ApiRoute {
    private String id;
    private String parentId;
    private String path;
    private String component;
    private String name;
    private Integer sort;
    private APIRouteMeta meta;
    private Boolean hidden;
//    private List<ApiRoute> children = new ArrayList<>();

    public static ApiRoute create(Menu menu) {
        return new ApiRoute()
                .setId(menu.getId())
                .setParentId(menu.getParentId())
                .setPath(menu.getPath())
                .setComponent(menu.getComponent())
                .setName(menu.getName())
                .setSort(menu.getSort())
                .setMeta(new APIRouteMeta().setIcon(menu.getIcon()).setTitle(menu.getName()))
                .setHidden("1".equals(menu.getHidden()))
                ;
    }
}
