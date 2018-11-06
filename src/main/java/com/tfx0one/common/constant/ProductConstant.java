package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 2018/6/9.
 */
public class ProductConstant {
    //商品的销售状态 0:上架（出售中），  1:仓储中     2：已售完
    public static byte SALE_STATUS_IN_SHELF = 0; //出售中
    public static byte SALE_STATUS_IN_STOCK = 1; //仓储中
    public static byte SALE_STATUS_SALE_OUT = 2; //已售完

    //商品分组
    public static int PRODUCT_GROUP_UNCLASSIFIED = 0; //未分组


    //商品类型
    public static byte PRODUCT_TYPE_NORMAL = 0; //普通商品
    public static byte PRODUCT_TYPE_PACKAGE = 1; //套餐商品

    //    //商品的服务方式 不需要的此功能了！
//    /**
//     * 服务方式 主要看有无物流 ...
//     无物流：店内消费（
//     顾客送车方式：
//        [0顾客自行送车到店 ，1.商家上门取车]
//
//     顾客提车方式：
//        [0顾客自行到店提车 ，1商家送车上门]）
//
//     本地配送 4
//
//     有物流：
//        8邮寄
//     */
//    public static byte PRODUCT_SERVICE_TYPE_CUSTOMER_CUSTOMER = 0; //顾客自行送车到店|顾客自行到店提车
//    public static byte PRODUCT_SERVICE_TYPE_CUSTOMER_VENDOR =   1; //顾客自行送车到店|商家送车上门
//
//    public static byte PRODUCT_SERVICE_TYPE_VENDOR_CUSTOMER =   2; //商家上门取车|顾客自行到店提车
//    public static byte PRODUCT_SERVICE_TYPE_VENDOR_VENDOR =     3; //商家上门取车|商家送车上门
//
//    public static byte PRODUCT_SERVICE_TYPE_LOCAL_DELIVERY = 4; //本地配送
//
//    public static byte PRODUCT_SERVICE_TYPE_MAILING_DELIVERY = 8; //邮寄


}
