package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.OrderDao;
import com.tfx0one.modules.ec.entity.OrderEntity;
import com.tfx0one.modules.ec.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new QueryPage<OrderEntity>().getPage(params),
                new LambdaQueryWrapper<OrderEntity>()
        );

        return new Pagination(page);
    }

}