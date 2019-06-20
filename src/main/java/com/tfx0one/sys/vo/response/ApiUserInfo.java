package com.tfx0one.sys.vo.response;

import com.tfx0one.sys.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.shiro.authz.AuthorizationInfo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Auth 2fx0one
 * 25/1/2019 00:28
 */
@ApiModel("用户信息")
@Accessors(chain = true)
@Data
public class ApiUserInfo {

    private String name;
    private String avatar;
    private String introduction;

    @ApiModelProperty(name = "路由列表", position = 1)
    private List<ApiRoute> routerList;
    @ApiModelProperty(name = "角色列表", position = 3)
    private Collection<String> roleList;
    @ApiModelProperty(name = "权限列表", position = 5)
    private Collection<String> permissionList;

    public static ApiUserInfo create(SysUser user, AuthorizationInfo info) {

        //路由数据
        List<ApiRoute> routers = user.getMenuList().stream()
                .map(ApiRoute::create)
                .collect(Collectors.toList());

        return new ApiUserInfo()
                .setAvatar(user.getPhoto())
                .setName(user.getLoginName())
                .setRouterList(routers)
                .setRoleList(info.getRoles())
                .setPermissionList(info.getStringPermissions());
    }
}
