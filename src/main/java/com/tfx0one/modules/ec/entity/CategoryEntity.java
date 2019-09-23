package com.tfx0one.modules.ec.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-09-23 00:14:35
 */
@Data
@TableName("ec_category")
@Accessors(chain = true)
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类目id
	 */
	@TableId
	private Long id;
	/**
	 * 类目名称
	 */
	private String name;
	/**
	 * 父类目id,顶级类目填0
	 */
	private Long parentId;
	/**
	 * 是否为父节点，0为否，1为是
	 */
	private Integer isParent;
	/**
	 * 排序指数，越小越靠前
	 */
	private Integer sort;

}
