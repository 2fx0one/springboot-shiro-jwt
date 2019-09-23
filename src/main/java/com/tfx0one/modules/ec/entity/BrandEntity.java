package com.tfx0one.modules.ec.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-09-23 00:14:35
 */
@Data
@TableName("ec_brand")
@Accessors(chain = true)
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long id;
	/**
	 * 品牌名称
	 */
	private String name;
	/**
	 * 品牌图片地址
	 */
	private String image;
	/**
	 * 品牌的首字母
	 */
	private String letter;

}
