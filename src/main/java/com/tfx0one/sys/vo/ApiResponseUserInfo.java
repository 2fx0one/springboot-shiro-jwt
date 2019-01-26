package com.tfx0one.sys.vo;

import com.tfx0one.sys.entity.Menu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.List;

/*
 * @Auth 2fx0one
 * 25/1/2019 00:28
 */
@ApiModel("用户信息")
//@Builder
@Accessors(chain = true)
@Data
public class ApiResponseUserInfo {

//    @ApiModelProperty
    private List<Menu> menuList;
//    @ApiModelProperty
    private Collection<String> permissionList;

    public static ApiResponseUserInfo create(List<Menu> menuList, Collection<String> stringPermissions) {
        return new ApiResponseUserInfo().setMenuList(menuList).setPermissionList(stringPermissions);
    }
}
