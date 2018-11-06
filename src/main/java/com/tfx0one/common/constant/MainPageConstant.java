package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 2018/7/23.
 */
public class MainPageConstant {

    public static byte CELL_IS_SHOW_YES = 0;
    public static byte CELL_IS_SHOW_NO = 1;

    //单元格类型 0:组  1:轮播栏元素 2:分类栏元素 3:热销栏元素 4:精选栏元素 5:公告 6: 大小图 7:视频 8:代言 9:专题 10:多轮播图1 11:多轮播图2
    // 12:多活动栏1 13:多活动栏2 14:多活动栏3 15:多活动栏4 16:多活动栏5 17:分享图
//    public static byte CELL_TYPE_GROUP = 0;
    public static final byte CELL_TYPE_SCROLL = 1;
    public static final byte CELL_TYPE_CLASSIFIED = 2;
    public static final byte CELL_TYPE_HOT = 3;
    public static final byte CELL_TYPE_RECOMMEND = 4;
    public static final byte CELL_TYPE_ANNOUNCE = 5;
    public static final byte CELL_TYPE_DUALIMAGE = 6;
    public static final byte CELL_TYPE_VIDEO = 7;
    public static final byte CELL_TYPE_REPRESENT = 8;
    public static final byte CELL_TYPE_TOPIC = 9;
    public static final byte CELL_TYPE_MULTISCRL1 = 10;
    public static final byte CELL_TYPE_MULTISCRL2 = 11;
    public static final byte CELL_TYPE_MULTIACT1 = 12;
    public static final byte CELL_TYPE_MULTIACT2 = 13;
    public static final byte CELL_TYPE_MULTIACT3 = 14;
    public static final byte CELL_TYPE_MULTIACT4 = 15;
    public static final byte CELL_TYPE_MULTIACT5 = 16;
    public static final byte CELL_TYPE_SHAREIMG = 17;
    // type 最大值
    public static final byte CELL_TYPE_MAX = 17;

    //单元格点击跳转的类型 -1:点击不跳转  -2:跳分组  -3:跳商品
    public static byte NAVIGATE_TYPE_TO_NULL = -1;
    public static byte NAVIGATE_TYPE_TO_GROUP = -2;
    public static byte NAVIGATE_TYPE_TO_PRODUCT = -3;

    // 页面附件数据类型定义
    public static final byte ATTACH_ITEM_IMG = 0;
    public static final byte ATTACH_ITEM_PRODUCT = 1;
}
