package com.tfx0one.modules.app.dao;

import com.tfx0one.modules.app.entity.OrderStatusEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单状态表
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
@Mapper
public interface OrderStatusDao extends BaseMapper<OrderStatusEntity> {
	
}
