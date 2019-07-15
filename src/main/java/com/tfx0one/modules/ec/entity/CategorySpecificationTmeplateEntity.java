package com.tfx0one.modules.ec.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 商品规格参数模板，json格式。
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Data
@TableName("ec_category_specification_tmeplate")
@Accessors(chain = true)
public class CategorySpecificationTmeplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 规格模板所属商品分类id
	 */
	@TableId
	private Long categoryId;
	/**
	 * 规格参数模板，json格式
	 */
	private String spuTemplate;

}
