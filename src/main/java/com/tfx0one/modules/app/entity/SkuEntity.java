package com.tfx0one.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * sku表,该表表示具体的商品实体,如黑色的 64g的iphone 8
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Data
@TableName("ec_sku")
@Accessors(chain = true)
public class SkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * sku id
	 */
	@TableId
	private Long id;
	/**
	 * spu id
	 */
	private Long spuId;
	/**
	 * 商品标题
	 */
	private String title;
	/**
	 * 商品的图片，多个图片以‘,’分割
	 */
	private String images;
	/**
	 * 销售价格，单位为分
	 */
	private Long price;
	/**
	 * 特有规格属性在spu属性模板中的对应下标组合
	 */
	private String indexes;
	/**
	 * sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序
	 */
	private String ownSpec;
	/**
	 * 是否有效，0无效，1有效
	 */
	private Integer enable;
	/**
	 * 添加时间
	 */
	private Date createTime;
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateTime;

}
