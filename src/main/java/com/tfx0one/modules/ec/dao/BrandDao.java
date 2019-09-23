package com.tfx0one.modules.ec.dao;

import com.tfx0one.modules.ec.entity.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-09-23 00:14:35
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
