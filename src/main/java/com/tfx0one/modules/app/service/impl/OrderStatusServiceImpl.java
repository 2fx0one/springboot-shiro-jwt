package com.tfx0one.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.app.dao.OrderStatusDao;
import com.tfx0one.modules.app.entity.OrderStatusEntity;
import com.tfx0one.modules.app.service.OrderStatusService;


@Service("orderStatusService")
public class OrderStatusServiceImpl extends ServiceImpl<OrderStatusDao, OrderStatusEntity> implements OrderStatusService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<OrderStatusEntity> page = this.page(
                new QueryPage<OrderStatusEntity>().getPage(params),
                new LambdaQueryWrapper<OrderStatusEntity>()
        );

        return new Pagination(page);
    }

}