package com.tfx0one.modules.ec.dao;

import com.tfx0one.modules.ec.entity.StockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存表，代表库存，秒杀库存等信息
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Mapper
public interface StockDao extends BaseMapper<StockEntity> {
	
}
