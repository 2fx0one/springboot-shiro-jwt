package com.tfx0one.modules.sys.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUserInfo {
    private Set<String> roles;
    private Set<String> permissions;
    private String name;
    private String avatar;
    private String introduction;

    public static ResponseUserInfo create(SysUserEntity user, Set<String> permissions) {
        return new ResponseUserInfo()
                .setName(user.getUsername())
                .setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .setIntroduction("user")
                .setPermissions(permissions);
    }
}
