package com.tfx0one.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.app.dao.CategorySpecificationTemplateDao;
import com.tfx0one.modules.app.entity.CategorySpecificationTemplateEntity;
import com.tfx0one.modules.app.service.CategorySpecificationTemplateService;


@Service("categorySpecificationTemplateService")
public class CategorySpecificationTemplateServiceImpl extends ServiceImpl<CategorySpecificationTemplateDao, CategorySpecificationTemplateEntity> implements CategorySpecificationTemplateService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<CategorySpecificationTemplateEntity> page = this.page(
                new QueryPage<CategorySpecificationTemplateEntity>().getPage(params),
                new LambdaQueryWrapper<CategorySpecificationTemplateEntity>()
        );

        return new Pagination(page);
    }

}