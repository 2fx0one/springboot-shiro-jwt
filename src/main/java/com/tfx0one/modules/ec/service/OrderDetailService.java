package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.OrderDetailEntity;

import java.util.Map;

/**
 * 订单详情表
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface OrderDetailService extends IService<OrderDetailEntity> {

    Pagination queryPage(Map<String, Object> params);
}

