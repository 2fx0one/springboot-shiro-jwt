package com.tfx0one.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.app.dao.CategoryDao;
import com.tfx0one.modules.app.entity.CategoryEntity;
import com.tfx0one.modules.app.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new QueryPage<CategoryEntity>().getPage(params),
                new LambdaQueryWrapper<CategoryEntity>()
        );

        return new Pagination(page);
    }

}