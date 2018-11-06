package com.tfx0one.common.constant;

public class CouponConstant {

    //指定时间段
    public static final Byte COUPON_USE_TYPE_PERIOD =1;
    //领券当日起
    public static final Byte COUPON_USE_TYPE_SAME =2;
    //领券次日起
    public static final Byte COUPON_USE_TYPE_NEXT =3;


    //现金券
    public static final Byte COUPON_CONDICTION_TYPE_CASH =1;
    //满减券
    public static final Byte COUPON_CONDICTION_TYPE_FULL =2;
    //折扣券
    public static final Byte COUPON_CONDICTION_TYPE_DISCOUNT =3;
    //折扣
    public static final Byte COUPON_VALUE_TYPE_DISCOUNT =2;
    //满减
    public static final Byte COUPON_VALUE_TYPE_FULL =1;

    //是限制领取次数
    public static final Byte COUPON_FOR_USER_TYPE_IS =1;
    //否限制领取次数
    public static final Byte COUPON_FOR_USER_TYPE_NO=0;

    //优惠券已删除
    public static final Byte COUPON_DEL_FLAG_EXPIRED =0;
    //优惠券未删除
    public static final Byte COUPON_DEL_FLAG_ON =1;
    //优惠券状态进行中
    public static final Byte COUPON_STATUS_ON =1;
    //优惠券状态已结束
    public static final Byte COUPON_STATUS_STOP =0;


    //用户优惠券已失效
    public static final Byte USER_COUPON_USE_INVALID =2;
    //用户优惠券未使用
    public static final Byte USER_COUPON_USE_NO =0;
    //用户优惠券已使用
    public static final Byte USER_COUPON_USE_IS =1;

    //全部商品
    public static final Byte COUPON_PRODUCT_SCOP_ALL =1;
    //部分商品
    public static final Byte COUPON_PRODUCT_SCOP_PART =2;
    //指定商品不可用
    public static final Byte COUPON_PRODUCT_SCOP_INVERSE =3;

//    //全平台优惠券
//    public static final Byte COUPON_SEND_TYPE_CODE_ALL =1;
//    //商品优惠券
//    public static final Byte COUPON_SEND_TYPE_CODE_PRODUCT =2;




}
