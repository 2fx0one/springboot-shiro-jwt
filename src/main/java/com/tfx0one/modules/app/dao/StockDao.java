package com.tfx0one.modules.app.dao;

import com.tfx0one.modules.app.entity.StockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存表，代表库存，秒杀库存等信息
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Mapper
public interface StockDao extends BaseMapper<StockEntity> {
	
}
