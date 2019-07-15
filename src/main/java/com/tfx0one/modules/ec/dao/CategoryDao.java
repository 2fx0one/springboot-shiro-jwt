package com.tfx0one.modules.ec.dao;

import com.tfx0one.modules.ec.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
