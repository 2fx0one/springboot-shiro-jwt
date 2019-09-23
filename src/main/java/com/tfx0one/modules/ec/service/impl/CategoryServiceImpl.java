package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.Query;

import com.tfx0one.modules.ec.dao.CategoryDao;
import com.tfx0one.modules.ec.entity.CategoryEntity;
import com.tfx0one.modules.ec.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public Pagination<CategoryEntity> queryPage(Map<String, Object> params, CategoryEntity category) {
        IPage<CategoryEntity> page = this.page(
                Query.page(params),
                Wrappers.<CategoryEntity>lambdaQuery()
        );

        return Pagination.create(page);
    }

}