package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 2018/7/16.
 */
public class OrderConstant {

//    购买方式 （1购物车购买 或者 2立即购买）
    public static byte ORDER_BUY_TYPE_TO_CART = 1; //购物车购买
    public static byte ORDER_BUY_TYPE_IMMEDIATELY  = 2;  //立即购买

    //订单快递状态
//    public static byte ORDER_SHIPMENT_STATUS_  = 1;  //

    //默认地址
    public static byte ADDRESS_IS_DEFAULT = 1;  //默认地址
    public static byte ADDRESS_IS_NOT_DEFAULT = 0; //不是默认地址



    //订单状态 1待付款； 2已付款（等待服务/等待发货）； 3服务完成/已发货； 4已完成（买家确认服务/已收货）； 5已关闭（款项最终没到账的）
    //public static byte ORDER_STATUS_COMPLETED = 0; //已完成
    public static byte ORDER_STATUS_WAIT_FOR_PAY = 1; //待付款
    public static byte ORDER_STATUS_WAIT_FOR_DELIVER = 2; //已付款（等待服务/等待发货）
    public static byte ORDER_STATUS_HAS_DELIVERED = 3; //服务完成/已发货
    public static byte ORDER_STATUS_COMPLETED = 4; //已完成 买家确认服务/已收货
    public static byte ORDER_STATUS_HAS_CLOSED = 5; //已关闭 （款项最终没到账的）

    //订单物品状态
    public static byte ORDER_GOODS_STATUS_NOT_AUTO_SEND = 0; //未自动发货
    public static byte ORDER_GOODS_STATUS_HAS_AUTO_SEND = 1; //已经自动发货


    //订单营销类型 0普通订单，1拼团订单
    public static byte ORDER_MARKETING_TYPE_NORMAL = 0; //0普通订单
    public static byte ORDER_MARKETING_TYPE_GROUP = 1; //1拼团订单


    //售后状态
    public static byte ORDER_REFUND_STATUS_NULL = -1; //无
    public static byte ORDER_REFUND_STATUS_RETURN_GOODS = 1; //退货中
    public static byte ORDER_REFUND_STATUS_RETURN_GOODS_COMPLETED = 2; //退货完成

    public static byte ORDER_REFUND_STATUS_RETURN_MONEY = 3; //退款中
    public static byte ORDER_REFUND_STATUS_RETURN_MONEY_COMPLETED = 4; //退款完成

    public static byte ORDER_REFUND_STATUS_NEGOTIATION = 5; //协商中
    public static byte ORDER_REFUND_STATUS_NEGOTIATION_COMPLETED = 6; //协商完成


    //订单来源（小程序，公众号）
    public static byte ORDER_FROM_TYPE_WX_MINI_PROGRAM = 1; //小程序
    public static byte ORDER_FROM_TYPE_WX_OFFICE_ACCOUNTS = 2; //公众号

}
