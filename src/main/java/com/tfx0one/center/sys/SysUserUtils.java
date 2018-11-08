package com.tfx0one.center.sys;

import com.tfx0one.center.sys.model.SysUser;
import com.tfx0one.center.sys.service.SysUserService;
import com.tfx0one.common.util.SpringContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author : 2fx0one
 * @date : 2018/11/8 17:31
 */
public class SysUserUtils {

    public static SysUserService sysUserService = SpringContextHolder.getBean(SysUserService.class);

    public static SysUser getLoginUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new RuntimeException("SecurityContextHolder.getContext().getAuthentication() == null");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("getCacheLoginUser() " + userDetails.getUsername());
        return sysUserService.getByUsername(userDetails.getUsername());
    }
}
