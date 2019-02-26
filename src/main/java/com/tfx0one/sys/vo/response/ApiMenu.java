package com.tfx0one.sys.vo.response;

import com.tfx0one.sys.entity.Menu;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/*
 * @Auth 2fx0one
 * 2019/2/26 20:18
 */
@ApiModel("菜单")
@Data
@Accessors(chain = true)
public class ApiMenu {

    private String parentId;

    private BigDecimal sort;

    private String isShow;

    private String href;

    private String target;

    private String icon;

    public static ApiMenu create(Menu m) {
        return new ApiMenu()
                .setParentId(m.getParentId())
                .setSort(m.getSort())
                .setIsShow(m.getIsShow())
                .setHref(m.getHref())
                .setTarget(m.getTarget())
                .setIcon(m.getIcon());

    }
}
