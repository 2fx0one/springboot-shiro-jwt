package com.tfx0one.common.sceurity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author: 2fx0one
 * @date:2018/11/6 17:03
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}