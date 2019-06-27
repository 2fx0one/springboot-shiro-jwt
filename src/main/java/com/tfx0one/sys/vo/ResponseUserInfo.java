package com.tfx0one.sys.vo;

import com.tfx0one.sys.entity.SysUserEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class ResponseUserInfo {
    private Set<String> roles;
    private String name;
    private String avatar;
    private String introduction;

    public static ResponseUserInfo create(SysUserEntity user, Set<String> permissions) {
        return new ResponseUserInfo().setName(user.getUsername()).setRoles(permissions);
    }
}
