package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 21/8/2018.
 */
public class PromotionConstant {

    //====== 促销类型 =====

    public static final byte RULE_TYPE_FULL_REDUCTION = 1; // 满减促销 满xx减xx

    public static final byte RULE_TYPE_FULL_GIFT = 2; // 满赠促销 满n元送某商品

    public static final byte RULE_TYPE_SINGLE_PRODUCT = 3; // 单品促销 促销xx折或者促销价

    public static final byte RULE_TYPE_PACKAGE = 4; // 套餐促销 商品组合

    public static final byte RULE_TYPE_GIFT = 5; // 赠品促销 购买主商品获得赠品

    public static final byte RULE_TYPE_BUY_MORE = 6; // 多买优惠

    public static final byte RULE_TYPE_DEPOSIT = 7;  // 定金优惠


    //======促销 产品范围： 全部参加， 部分参加， 部分不参加=====
    public static final byte PRODUCT_RANGE_TYPE_ALL = 0; //全部参加
    public static final byte PRODUCT_RANGE_TYPE_INCLUDE = 1; //部分参加
//    public static final byte PRODUCT_RANGE_TYPE_EXCLUDE = 2; //部分不参加

    //=====促销活动状态    1进行中   0已结束====
//    public static final byte PROMOTION_STATUS_READY = 1; //未开启
    public static final byte PROMOTION_STATUS_PROCESSING = 1; //进行中
    public static final byte PROMOTION_STATUS_STOP = 0; //已结束




}
