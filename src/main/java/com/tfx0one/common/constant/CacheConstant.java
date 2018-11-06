package com.tfx0one.common.constant;

import java.util.Map;

/**
 * Created by 2fx0one on 28/5/2018.
 */
public class CacheConstant {

    private static Map<String, String> map;

    // 微信用户缓存 session_key
    // https://developers.weixin.qq.com/miniprogram/dev/api/signature.html#wxchecksessionobject
    public static final String CACHE_WX_SESSION_KEY_BY_USER_ID = "CACHE_WX_SESSION_KEY_BY_USER_ID";

    //商户 缓存微信的 BASE_ACCESSS_TOKEN
    public static final String CACHE_WX_BASE_ACCESS_TOKEN_BY_APPID_ID = "CACHE_WX_BASE_ACCESS_TOKEN_BY_APPID_ID";



    //用户相关
    public static final String CACHE_ACCOUNT_BY_USERNAME = "CACHE_ACCOUNT_BY_USERNAME";

    //缓存角色
    public static final String CACHE_USER_ROLE_BY_ID = "CACHE_USER_ROLE_BY_ID"; //角色 按照 ID 缓存

    //商家
    public static final String CACHE_VENDOR_BY_APP_ID = "CACHE_VENDOR_BY_APP_ID";


//    public static final String CACHE_PRODUCT_SPU = "CACHE_PRODUCT_SPU";
//    public static final String CACHE_PRODUCT_SKU = "CACHE_PRODUCT_SKU";
//    public static final String CACHE_PRODUCT_SKU_ATTR = "CACHE_PRODUCT_SKU_ATTR";

    //商品中心相关
    //product 商品
    public static final String CACHE_PRODUCT_SPU_BY_ID = "CACHE_PRODUCT_SPU_BY_ID"; //商品SPU 按照商品ID缓存
    public static final String CACHE_PRODUCT_SPU_BY_VENDOR_ID = "CACHE_PRODUCT_SPU_BY_VENDOR_ID"; //商品SPU 按照 商家ID 缓存

    //商品分组
    public static final String CACHE_PRODUCT_GROUP_BY_ID = "CACHE_PRODUCT_GROUP_BY_ID"; //单品SKU属性 按照 用户ID 缓存
    public static final String CACHE_PRODUCT_GROUP_BY_VENDOR_ID = "CACHE_PRODUCT_GROUP_BY_VENDOR_ID"; //单品SKU属性 按照 用户ID 缓存


    //sku 单品
    public static final String CACHE_PRODUCT_SKU_BY_ID = "CACHE_PRODUCT_SKU_BY_ID"; //单品SKU 按照单品ID缓存
    public static final String CACHE_PRODUCT_SKU_BY_PRODUCT_ID = "CACHE_PRODUCT_SKU_BY_PRODUCT_ID"; //单品SKU 按照 商品ID 缓存

    //skuattr 单品属性
    public static final String CACHE_SKU_ATTR_BY_ID = "CACHE_SKU_ATTR_BY_ID"; //单品SKU属性 按照属性ID缓存
    public static final String CACHE_SKU_ATTR_BY_PRODUCT_ID = "CACHE_SKU_ATTR_BY_PRODUCT_ID"; //单品SKU属性 按照 商品ID 缓存
    public static final String CACHE_SKU_ATTR_BY_VENDOR_ID = "CACHE_SKU_ATTR_BY_VENDOR_ID"; //单品SKU属性 按照 商家ID 缓存



    //促销缓存
    public static final String CACHE_MARKETING_BY_ID = "CACHE_MARKETING_BY_ID"; //促销活动 按照 ID 缓存
    public static final String CACHE_MARKETING_DETAIL_BY_PRODUCT_ID = "CACHE_MARKETING_DETAIL_BY_PRODUCT_ID"; //促销活动详情 按照 商品ID 缓存



    //缓存权限
    public static final String CACHE_ROLE_PERMISSION_BY_ID = "CACHE_ROLE_PERMISSION_BY_ID";
    public static final String CACHE_ROLE_PERMISSION_BY_ROLE_ID = "CACHE_ROLE_PERMISSION_BY_ROLE_ID";

//    public static final String CACHE_PRODUCT_STORAGE_BY_ID = "CACHE_PRODUCT_STORAGE_BY_ID"; //库存 缓存ID


    //商户图片
    public static final String CACHE_VENDOR_IMAGE_BY_ID = "CACHE_VENDOR_IMAGE_BY_ID";
    public static final String CACHE_VENDOR_IMAGE_BY_VENDOR_ID = "CACHE_VENDOR_IMAGE_BY_VENDOR_ID";


    //订单相关
    public static final String CACHE_ORDER_BY_ID = "CACHE_ORDER_BY_ID";

    //短信验证码 Verification Code
    public static final String CACHE_VERIFICATION_CODE_BY_USER_ID = "CACHE_VERIFICATION_CODE_BY_USER_ID";

    //套餐相关缓存
//    public static final String CACHE_USER_PACKAGE_BY_USER_PACKAGE_ID = "CACHE_USER_PACKAGE_BY_USER_PACKAGE_ID";

    //预约服务缓存
//    public static final String CACHE_RESERVATION_BY_USER_ID = "CACHE_RESERVATION_BY_USER_ID";
//    public static final String CACHE_RESERVATION_BY_ID = "CACHE_RESERVATION_BY_ID";

    //预约服务项目缓存
//    public static final String CACHE_RESERVATION_ITEM_BY_ID = "CACHE_RESERVATION_ITEM_BY_ID";


}
