package com.tfx0one.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.app.entity.OrderEntity;

import java.util.Map;

/**
 * 
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
public interface OrderService extends IService<OrderEntity> {

    Pagination queryPage(Map<String, Object> params);
}

