package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.SpuDetailDao;
import com.tfx0one.modules.ec.entity.SpuDetailEntity;
import com.tfx0one.modules.ec.service.SpuDetailService;


@Service("spuDetailService")
public class SpuDetailServiceImpl extends ServiceImpl<SpuDetailDao, SpuDetailEntity> implements SpuDetailService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<SpuDetailEntity> page = this.page(
                new QueryPage<SpuDetailEntity>().getPage(params),
                new LambdaQueryWrapper<SpuDetailEntity>()
        );

        return new Pagination(page);
    }

}