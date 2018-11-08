package com.tfx0one.common.sceurity.impl;

import com.tfx0one.center.sys.model.SysUser;
import com.tfx0one.center.sys.service.SysUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by 2fx0one on 2018/6/4.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username == null) {
            throw new UsernameNotFoundException("No user found with username 'null' !");
        }
        SysUser sysUser = sysUserService.getByUsername(username);

        if (sysUser == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        List<SimpleGrantedAuthority> authorities = Collections.emptyList();
        //TODO： 未来存在多个角色的情况
//        authorities.add(new SimpleGrantedAuthority("ROLE_ID_" + sysUser.getId().toString()));
        return new UserDetailsImpl(
//                sysUser,
                sysUser.getUsername(),
                sysUser.getPassword(),
                authorities);
    }
}
