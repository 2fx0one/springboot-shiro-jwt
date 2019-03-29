package com.tfx0one.sys.vo.response;

import com.tfx0one.sys.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
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

    private List<ApiRoute> routers;
    private Collection<String> roles;
    private Collection<String> permissionList;

    public static ApiUserInfo create(User user, AuthorizationInfo info) {

        //路由数据
        List<ApiRoute> routers = user.getMenuList().stream()
                .map(ApiRoute::create)
                .filter(e -> StringUtils.isNotBlank(e.getComponent()))
                .collect(Collectors.toList());
        return new ApiUserInfo()
                .setName(user.getLoginName())
                .setRouters(routers)
                .setRoles(info.getRoles())
                .setPermissionList(info.getStringPermissions());
    }
}
