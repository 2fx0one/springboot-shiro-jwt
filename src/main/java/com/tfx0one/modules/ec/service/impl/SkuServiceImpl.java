package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.SkuDao;
import com.tfx0one.modules.ec.entity.SkuEntity;
import com.tfx0one.modules.ec.service.SkuService;


@Service("skuService")
public class SkuServiceImpl extends ServiceImpl<SkuDao, SkuEntity> implements SkuService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<SkuEntity> page = this.page(
                new QueryPage<SkuEntity>().getPage(params),
                new LambdaQueryWrapper<SkuEntity>()
        );

        return new Pagination(page);
    }

}