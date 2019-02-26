package com.tfx0one.sys.vo.response;

import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.entity.Role;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Auth 2fx0one
 * 25/1/2019 00:28
 */
@ApiModel("用户信息")
//@Builder
@Accessors(chain = true)
@Data
public class ApiUserInfo {

    private List<String> roleList;
//    @ApiModelProperty
    private List<ApiMenu> menuList;
//    @ApiModelProperty
    private Collection<String> permissionList;

    public static ApiUserInfo create(List<Role> roleList, List<Menu> menuList, Collection<String> stringPermissions) {
        return new ApiUserInfo()
                .setRoleList(roleList.stream().map(Role::getEnname).collect(Collectors.toList()))
                .setMenuList(menuList.stream().map(ApiMenu::create).collect(Collectors.toList()))
                .setPermissionList(stringPermissions);
    }
}
