package com.tfx0one.modules.app.dao;

import com.tfx0one.modules.app.entity.CategoryBrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类和品牌的中间表，两者是多对多关系
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Mapper
public interface CategoryBrandDao extends BaseMapper<CategoryBrandEntity> {
	
}
