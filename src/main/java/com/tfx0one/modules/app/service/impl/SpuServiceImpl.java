package com.tfx0one.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.app.dao.SpuDao;
import com.tfx0one.modules.app.entity.SpuEntity;
import com.tfx0one.modules.app.service.SpuService;


@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuDao, SpuEntity> implements SpuService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<SpuEntity> page = this.page(
                new QueryPage<SpuEntity>().getPage(params),
                new LambdaQueryWrapper<SpuEntity>()
        );

        return new Pagination(page);
    }

}