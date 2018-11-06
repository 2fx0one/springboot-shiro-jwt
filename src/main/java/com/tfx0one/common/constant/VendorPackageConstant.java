package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 6/8/2018.
 */
public class VendorPackageConstant {
    //预约服务状态 1:固定日期    2:购买当日起   3:购买次日起    4:永远不过期
    public static final byte VENDOR_PACKAGE_LIMITED_TIME_TYPE_FIXED = 1; //固定日期
    public static final byte VENDOR_PACKAGE_LIMITED_TIME_TYPE_SAME_DAY = 2; //购买当日起
    public static final byte VENDOR_PACKAGE_LIMITED_TIME_TYPE_NEXT_DAY = 3; //购买次日起
    public static final byte VENDOR_PACKAGE_LIMITED_TIME_TYPE_FOREVER = 4; //永远不过期
}
