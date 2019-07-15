package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.StockDao;
import com.tfx0one.modules.ec.entity.StockEntity;
import com.tfx0one.modules.ec.service.StockService;


@Service("stockService")
public class StockServiceImpl extends ServiceImpl<StockDao, StockEntity> implements StockService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<StockEntity> page = this.page(
                new QueryPage<StockEntity>().getPage(params),
                new LambdaQueryWrapper<StockEntity>()
        );

        return new Pagination(page);
    }

}