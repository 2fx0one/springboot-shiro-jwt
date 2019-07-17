package com.tfx0one.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * spu表，该表描述的是一个抽象性的商品，比如 iphone8
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Data
@TableName("ec_spu")
@Accessors(chain = true)
public class SpuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * spu id
	 */
	@TableId
	private Long id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 子标题
	 */
	private String subTitle;
	/**
	 * 1级类目id
	 */
	private Long cid1;
	/**
	 * 2级类目id
	 */
	private Long cid2;
	/**
	 * 3级类目id
	 */
	private Long cid3;
	/**
	 * 商品所属品牌id
	 */
	private Long brandId;
	/**
	 * 是否上架，0下架，1上架
	 */
	private Integer saleable;
	/**
	 * 是否有效，0已删除，1有效
	 */
	private Integer valid;
	/**
	 * 添加时间
	 */
	private Date createTime;
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateTime;

}
