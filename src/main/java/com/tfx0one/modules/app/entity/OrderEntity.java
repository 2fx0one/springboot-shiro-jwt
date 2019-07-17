package com.tfx0one.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Data
@TableName("ec_order")
@Accessors(chain = true)
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Long id;
	/**
	 * 总金额，单位为分
	 */
	private Long totalPay;
	/**
	 * 实付金额。单位:分。如:20007，表示:200元7分
	 */
	private Long actualPay;
	/**
	 * 
	 */
	private String promotionIds;
	/**
	 * 支付类型，1、在线支付，2、货到付款
	 */
	private Integer paymentType;
	/**
	 * 邮费。单位:分。如:20007，表示:200元7分
	 */
	private Long postFee;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 物流名称
	 */
	private String shippingName;
	/**
	 * 物流单号
	 */
	private String shippingCode;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 买家留言
	 */
	private String buyerMessage;
	/**
	 * 买家昵称
	 */
	private String buyerNick;
	/**
	 * 买家是否已经评价,0未评价，1已评价
	 */
	private Integer buyerRate;
	/**
	 * 收获地址（省）
	 */
	private String receiverState;
	/**
	 * 收获地址（市）
	 */
	private String receiverCity;
	/**
	 * 收获地址（区/县）
	 */
	private String receiverDistrict;
	/**
	 * 收获地址（街道、住址等详细地址）
	 */
	private String receiverAddress;
	/**
	 * 收货人手机
	 */
	private String receiverMobile;
	/**
	 * 收货人邮编
	 */
	private String receiverZip;
	/**
	 * 收货人
	 */
	private String receiver;
	/**
	 * 发票类型(0无发票1普通发票，2电子发票，3增值税发票)
	 */
	private Integer invoiceType;
	/**
	 * 订单来源：1:app端，2：pc端，3：M端，4：微信端，5：手机qq端
	 */
	private Integer sourceType;

}
