package com.tfx0one.modules.ec.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 订单详情表
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Data
@TableName("ec_order_detail")
@Accessors(chain = true)
public class OrderDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单详情id 
	 */
	@TableId
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * sku商品id
	 */
	private Long skuId;
	/**
	 * 购买数量
	 */
	private Integer num;
	/**
	 * 商品标题
	 */
	private String title;
	/**
	 * 商品动态属性键值集
	 */
	private String ownSpec;
	/**
	 * 价格,单位：分
	 */
	private Long price;
	/**
	 * 商品图片
	 */
	private String image;

}
