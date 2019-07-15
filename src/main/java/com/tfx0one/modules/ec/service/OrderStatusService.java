package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.OrderStatusEntity;

import java.util.Map;

/**
 * 订单状态表
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface OrderStatusService extends IService<OrderStatusEntity> {

    Pagination queryPage(Map<String, Object> params);
}

