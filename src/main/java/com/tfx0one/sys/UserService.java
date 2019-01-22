package com.tfx0one.sys;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public User getByUsername(String username) {
        User u = new User();
        u.setUsername(username);
        u.setPassword("password");
        u.setRole("admin");
        u.setPermission("user:list:view");
        return u;
    }
}
