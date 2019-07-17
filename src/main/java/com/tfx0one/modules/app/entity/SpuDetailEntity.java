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
@TableName("ec_spu_detail")
@Accessors(chain = true)
public class SpuDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long spuId;
	/**
	 * 商品描述信息
	 */
	private String description;
	/**
	 * 全部规格参数数据
	 */
	private String specifications;
	/**
	 * 特有规格参数及可选值信息，json格式
	 */
	private String skuOptions;
	/**
	 * 包装清单
	 */
	private String packingList;
	/**
	 * 售后服务
	 */
	private String afterService;

}
