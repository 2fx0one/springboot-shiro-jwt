package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.CategoryBrandDao;
import com.tfx0one.modules.ec.entity.CategoryBrandEntity;
import com.tfx0one.modules.ec.service.CategoryBrandService;


@Service("categoryBrandService")
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandDao, CategoryBrandEntity> implements CategoryBrandService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<CategoryBrandEntity> page = this.page(
                new QueryPage<CategoryBrandEntity>().getPage(params),
                new LambdaQueryWrapper<CategoryBrandEntity>()
        );

        return new Pagination(page);
    }

}