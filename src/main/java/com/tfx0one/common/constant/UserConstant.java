package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 2018/6/1.
 */
public class UserConstant {


    //status
    public static final byte USER_STATUS_NORMAL = 0; // 微信用户状态 正常
    public static final byte USER_STATUS_STOP = 1; // 微信用户状态 停用


    //============ 注意！！！ 基础的必备角色数据 必须和数据库一一对应对应  =============
    //TODO：项目启动加入检查逻辑
    //user role id 注意！！！ 必须和数据库对应
    public static final int USER_ROLE_ID_ADMIN = 0; //超级管理员 数据库有用户记录，没有角色表记录
    public static final int USER_ROLE_ID_VENDOR = 1; //商户
    public static final int USER_ROLE_ID_CONSUMER = 2; //消费者

    //role permission string 注意！！！ 必须和数据库对应
//    public static final String USER_ROLE_PERMISSION_ADMIN = "ADMIN"; //超级管理员
//    public static final String USER_ROLE_PERMISSION_VENDOR = "VENDOR"; //商家
//    public static final String USER_ROLE_PERMISSION_CONSUMER = "CONSUMER"; //消费者

    //role title
//    public static final String USER_ROLE_TITLE_ADMIN = "超级管理员";
//    public static final String USER_ROLE_TITLE_VENDOR = "商家";
//    public static final String USER_ROLE_TITLE_CONSUMER = "消费者";

//    public static Map<Integer, String> rolePermission;
//    static {
//        rolePermission = new HashMap<>();
//        rolePermission.put(USER_ROLE_ID_ADMIN, USER_ROLE_PERMISSION_ADMIN);
//        rolePermission.put(USER_ROLE_ID_VENDOR, USER_ROLE_PERMISSION_VENDOR);
//        rolePermission.put(USER_ROLE_ID_CONSUMER, USER_ROLE_PERMISSION_CONSUMER);
//}


}
