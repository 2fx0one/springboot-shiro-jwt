package com.tfx0one.center.sys.util;

import com.tfx0one.center.sys.mapper.*;
import com.tfx0one.common.util.SpringContextHolder;

/**
 * @author : 2fx0one
 * @date : 2018/11/28 16:21
 */
public class UserUtils {
    private static SysUserDao sysUserDao = SpringContextHolder.getBean(SysUserDao.class);
    private static SysRoleDao sysRoleDao = SpringContextHolder.getBean(SysRoleDao.class);
    private static SysMenuDao sysMenuDao = SpringContextHolder.getBean(SysMenuDao.class);
    private static SysAreaDao sysAreaDao = SpringContextHolder.getBean(SysAreaDao.class);
    private static SysOfficeDao sysOfficeDao = SpringContextHolder.getBean(SysOfficeDao.class);
}
