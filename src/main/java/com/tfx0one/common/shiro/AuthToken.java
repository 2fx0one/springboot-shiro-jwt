package com.tfx0one.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class AuthToken implements AuthenticationToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
