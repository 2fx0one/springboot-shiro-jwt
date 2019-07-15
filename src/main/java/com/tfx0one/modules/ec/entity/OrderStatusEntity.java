package com.tfx0one.modules.ec.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 订单状态表
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Data
@TableName("ec_order_status")
@Accessors(chain = true)
public class OrderStatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Long orderId;
	/**
	 * 状态：1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价
	 */
	private Integer status;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 付款时间
	 */
	private Date paymentTime;
	/**
	 * 发货时间
	 */
	private Date consignTime;
	/**
	 * 交易完成时间
	 */
	private Date endTime;
	/**
	 * 交易关闭时间
	 */
	private Date closeTime;
	/**
	 * 评价时间
	 */
	private Date commentTime;

}
