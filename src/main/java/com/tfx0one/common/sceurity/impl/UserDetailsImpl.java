package com.tfx0one.common.sceurity.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfx0one.web.sys.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by 2fx0one on 2018/6/4.
 */

//包装 JWT 的 User
public class UserDetailsImpl implements UserDetails {
    private final String username;
    private final String password;

//    private final SysUser sysUser;

    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(
//            SysUser sysUser,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
//        this.id = String.valueOf(userAccount.getId());
        this.username = username;
        this.password = password; //new BCryptPasswordEncoder().encode(passwd) 加密
//        this.email = email;
//        this.sysUser = sysUser;
        this.authorities = authorities;
//        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    //是否是超级管理员
//    public boolean isAdmin()
//    {
//        return UserConstant.USER_ROLE_ID_ADMIN == this.account.getRoleId();
//    }


    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


//    @JsonIgnore
//    public String getId() {
//        return this.sysUser.getId().toString();
//    }

//    @JsonIgnore
//    public int getRoleId() {
//        return this.sysUser.getRoleId();
//    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        System.out.println("isEnabled()  用户状态 默认是true ");
        return true;
    }

    // 这个是自定义的，返回上次密码重置日期
//    @JsonIgnore
//    public Date getLastPasswordResetDate() {
////        return this.account.getLastResetPasswordTime();
//        return null;
//    }
}
