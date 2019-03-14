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

    private String id;

    private String parentId;

    private BigDecimal sort;

    private String isShow;

    private String href;

    private String target;

    private String icon;

    private String path;

    private String permission;


    public static ApiMenu create(Menu m) {
        return new ApiMenu()
                .setId(m.getId())
                .setParentId(m.getParentId())
                .setSort(m.getSort())
                .setIsShow(m.getIsShow())
                .setHref(m.getHref())
                .setTarget(m.getTarget())
                .setIcon(m.getIcon())
                .setPath(m.getPath())
                .setPermission(m.getPermission())
                ;

    }

    public Menu entity() {
        Menu r = new Menu()
                .setParentId(this.parentId)
                .setSort(this.sort)
                .setIsShow(this.isShow)
                .setHref(this.href)
                .setTarget(this.target)
                .setIcon(this.icon)
                .setPath(this.path)
                .setPermission(this.permission)
                ;
        r.setId(this.id);
        return r;
    }
}
