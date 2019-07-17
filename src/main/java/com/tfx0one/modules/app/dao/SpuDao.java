package com.tfx0one.modules.app.dao;

import com.tfx0one.modules.app.entity.SpuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu表，该表描述的是一个抽象性的商品，比如 iphone8
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Mapper
public interface SpuDao extends BaseMapper<SpuEntity> {
	
}
