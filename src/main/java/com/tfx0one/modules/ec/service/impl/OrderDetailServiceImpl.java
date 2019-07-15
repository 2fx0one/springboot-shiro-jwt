package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.OrderDetailDao;
import com.tfx0one.modules.ec.entity.OrderDetailEntity;
import com.tfx0one.modules.ec.service.OrderDetailService;


@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao, OrderDetailEntity> implements OrderDetailService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<OrderDetailEntity> page = this.page(
                new QueryPage<OrderDetailEntity>().getPage(params),
                new LambdaQueryWrapper<OrderDetailEntity>()
        );

        return new Pagination(page);
    }

}