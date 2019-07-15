package com.tfx0one.modules.ec.dao;

import com.tfx0one.modules.ec.entity.SkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku表,该表表示具体的商品实体,如黑色的 64g的iphone 8
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Mapper
public interface SkuDao extends BaseMapper<SkuEntity> {
	
}
