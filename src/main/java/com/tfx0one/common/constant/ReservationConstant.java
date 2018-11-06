package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 3/8/2018.
 */
public class ReservationConstant {

    //预约服务状态 1:预约已提交  2:预约已确认   3:预约已取消   4:商家确认服务完成   0:用户确认服务完成
    public static final byte RESERVATION_STATUS_SUBMIT = 1; //申请提交
    public static final byte RESERVATION_STATUS_CONFIRM = 2; //预约已确认
    public static final byte RESERVATION_STATUS_CANCEL = 3; //预约已取消
    public static final byte RESERVATION_STATUS_VENDOR_COMPLETED = 4; //商家确认服务完成
    public static final byte RESERVATION_STATUS_COMPLETED = 0; //用户确认服务完成

}
