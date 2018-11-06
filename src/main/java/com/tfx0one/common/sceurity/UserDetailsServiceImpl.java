package com.tfx0one.common.sceurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

import static java.util.Collections.emptyList;

/**
 * @author: 2fx0one
 * @date:2018/11/6 16:54
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //TODO  拿到角色列表

        return new org.springframework.security.core.userdetails.User("admin", "123456", emptyList());

    }
}
