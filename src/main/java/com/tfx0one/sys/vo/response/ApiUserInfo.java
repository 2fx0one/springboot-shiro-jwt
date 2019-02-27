package com.tfx0one.sys.vo.response;

import com.tfx0one.sys.entity.Menu;
import com.tfx0one.sys.entity.Role;
import com.tfx0one.sys.entity.User;
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

    private String name;
    private String avatar;
    private String introduction;

    private List<String> roles;
//    @ApiModelProperty
    private List<String> pathList;
//    @ApiModelProperty
    private Collection<String> permissionList;

    public static ApiUserInfo create(User user, Collection<String> stringPermissions) {
        return new ApiUserInfo()
                .setName(user.getLoginName())
                .setRoles(user.getRoleList().stream().map(Role::getEnname).collect(Collectors.toList()))
                .setPathList(user.getMenuList().stream().map(Menu::getPath).collect(Collectors.toList()))
                .setPermissionList(stringPermissions);
    }
}
