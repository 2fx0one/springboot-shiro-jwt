package com.tfx0one.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 库存表，代表库存，秒杀库存等信息
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Data
@TableName("ec_stock")
@Accessors(chain = true)
public class StockEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 库存对应的商品sku id
	 */
	@TableId
	private Long skuId;
	/**
	 * 可秒杀库存
	 */
	private Integer secondKillStock;
	/**
	 * 秒杀总数量
	 */
	private Integer secondKillTotal;
	/**
	 * 库存数量
	 */
	private Integer stock;

}
