package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 2018/6/16.
 */
public class PaymentConstant {

    //支付状态 （0已付款， 1等待支付）
    public static final byte PAYMENT_STATUS_PAY_COMPLETED = 0; //已付款
    public static final byte PAYMENT_STATUS_WAIT_FOR_PAY = 1; //等待支付


    //支付方式 （1微信 2银联）
    public static byte PAYMENT_TYPE_WECHAT = 1; //微信
    public static byte PAYMENT_TYPE_UNIONPAY = 2; //银联



}
