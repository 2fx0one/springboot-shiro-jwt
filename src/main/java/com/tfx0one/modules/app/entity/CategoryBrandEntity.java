package com.tfx0one.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 商品分类和品牌的中间表，两者是多对多关系
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Data
@TableName("ec_category_brand")
@Accessors(chain = true)
public class CategoryBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品类目id
	 */
	@TableId
	private Long categoryId;
	/**
	 * 品牌id
	 */
	private Long brandId;

}
