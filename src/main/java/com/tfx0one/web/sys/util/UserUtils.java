package com.tfx0one.web.sys.util;

import com.tfx0one.common.sceurity.impl.UserDetailsImpl;
import com.tfx0one.common.util.SpringContextHolder;
import com.tfx0one.web.sys.dao.*;
import com.tfx0one.web.sys.entity.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

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

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

    public static final String CACHE_AUTH_INFO = "authInfo";
    public static final String CACHE_ROLE_LIST = "roleList";
    public static final String CACHE_MENU_LIST = "menuList";
    public static final String CACHE_AREA_LIST = "areaList";
    public static final String CACHE_OFFICE_LIST = "officeList";
    public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";


    public static SysUser getUser() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            throw new RuntimeException("SecurityContextHolder.getContext().getAuthentication() == null");
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("getCacheLoginUser() " + userDetails.getUsername());
//        EShopAccount account = accountService.selectByUsername(userDetails.getUsername());
//        logger.info("获取当前登录【账号】信息失败！");
//        Assert.notNull(account, "获取当前登录【账号】信息失败！");
        return new SysUser().withLoginName(userDetails.getUsername());
    }
//    /**
//     * 根据ID获取用户
//     * @param id
//     * @return 取不到返回null
//     */
//    public static SysUser get(String id){
//        SysUser user = CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
//        if (user ==  null){
//            user = sysUserDao.selectByPrimaryKey(id);
//            if (user == null){
//                return null;
//            }
//            user.setRoleList(sysRoleDao.listByUserId(user.getId());
//            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
//            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
//        }
//        return user;
//    }
//
//    /**
//     * 根据登录名获取用户
//     * @param loginName
//     * @return 取不到返回null
//     */
//    public static SysUsergetByLoginName(String loginName){
//        SysUser user = CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
//        if (user == null){
//            user = sysUserDao.getByLoginName(new SysUser().withLoginName(loginName));
//            if (user == null){
//                return null;
//            }
//            user.setRoleList(sysRoleDao.listByUserId(user.getId());
//            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
//            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
//        }
//        return user;
//    }
//
//    /**
//     * 清除当前用户缓存
//     */
//    public static void clearCache(){
//        removeCache(CACHE_AUTH_INFO);
//        removeCache(CACHE_ROLE_LIST);
//        removeCache(CACHE_MENU_LIST);
//        removeCache(CACHE_AREA_LIST);
//        removeCache(CACHE_OFFICE_LIST);
//        removeCache(CACHE_OFFICE_ALL_LIST);
//        UserUtils.clearCache(getUser());
//    }
//
//    /**
//     * 清除指定用户缓存
//     * @param user
//     */
//    public static void clearCache(SysUser user){
//        CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
//        CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
//        CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getOldLoginName());
//        if (user.getOffice() != null && user.getOffice().getId() != null){
//            CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getOffice().getId());
//        }
//    }
//
//    /**
//     * 获取当前用户
//     * @return 取不到返回 new User()
//     */
//    public static SysUser getUser(){
//        Principal principal = getPrincipal();
//        if (principal!=null){
//            SysUser user = get(principal.getId());
//            if (user != null){
//                return user;
//            }
//            return new User();
//        }
//        // 如果没有登录，则返回实例化空的User对象。
//        return new User();
//    }
//
//    /**
//     * 获取当前用户角色列表
//     * @return
//     */
//    public static List<Role> getRoleList(){
//        @SuppressWarnings("unchecked")
//        List<Role> roleList = (List<Role>)getCache(CACHE_ROLE_LIST);
//        if (roleList == null){
//            SysUser user = getUser();
//            if (user.isAdmin()){
//                roleList = roleDao.findAllList(new Role());
//            }else{
//                Role role = new Role();
//                role.getSqlMap().put("dsf", BaseService.dataScopeFilter(user.getCurrentUser(), "o", "u"));
//                roleList = roleDao.findList(role);
//            }
//            putCache(CACHE_ROLE_LIST, roleList);
//        }
//        return roleList;
//    }
//
//    /**
//     * 获取当前用户授权菜单
//     * @return
//     */
//    public static List<Menu> getMenuList(){
//        @SuppressWarnings("unchecked")
//        List<Menu> menuList = (List<Menu>)getCache(CACHE_MENU_LIST);
//        if (menuList == null){
//            SysUser user = getUser();
//            if (user.isAdmin()){
//                menuList = menuDao.findAllList(new Menu());
//            }else{
//                Menu m = new Menu();
//                m.setUserId(user.getId());
//                menuList = menuDao.findByUserId(m);
//            }
//            putCache(CACHE_MENU_LIST, menuList);
//        }
//        return menuList;
//    }
//
//    /**
//     * 获取当前用户授权的区域
//     * @return
//     */
//    public static List<Area> getAreaList(){
//        @SuppressWarnings("unchecked")
//        List<Area> areaList = (List<Area>)getCache(CACHE_AREA_LIST);
//        if (areaList == null){
//            areaList = areaDao.findAllList(new Area());
//            putCache(CACHE_AREA_LIST, areaList);
//        }
//        return areaList;
//    }
//
//    /**
//     * 获取当前用户有权限访问的部门
//     * @return
//     */
//    public static List<Office> getOfficeList(){
//        @SuppressWarnings("unchecked")
//        List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_LIST);
//        if (officeList == null){
//            SysUser user = getUser();
//            if (user.isAdmin()){
//                officeList = officeDao.findAllList(new Office());
//            }else{
//                Office office = new Office();
//                office.getSqlMap().put("dsf", BaseService.dataScopeFilter(user, "a", ""));
//                officeList = officeDao.findList(office);
//            }
//            putCache(CACHE_OFFICE_LIST, officeList);
//        }
//        return officeList;
//    }
//
//    /**
//     * 获取当前用户有权限访问的部门
//     * @return
//     */
//    public static List<Office> getOfficeAllList(){
//        @SuppressWarnings("unchecked")
//        List<Office> officeList = (List<Office>)getCache(CACHE_OFFICE_ALL_LIST);
//        if (officeList == null){
//            officeList = officeDao.findAllList(new Office());
//        }
//        return officeList;
//    }
}
