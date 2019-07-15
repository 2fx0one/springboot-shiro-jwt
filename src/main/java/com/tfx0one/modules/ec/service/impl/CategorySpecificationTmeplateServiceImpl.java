package com.tfx0one.modules.ec.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;

import com.tfx0one.modules.ec.dao.CategorySpecificationTmeplateDao;
import com.tfx0one.modules.ec.entity.CategorySpecificationTmeplateEntity;
import com.tfx0one.modules.ec.service.CategorySpecificationTmeplateService;


@Service("categorySpecificationTmeplateService")
public class CategorySpecificationTmeplateServiceImpl extends ServiceImpl<CategorySpecificationTmeplateDao, CategorySpecificationTmeplateEntity> implements CategorySpecificationTmeplateService {

    @Override
    public Pagination queryPage(Map<String, Object> params) {
        IPage<CategorySpecificationTmeplateEntity> page = this.page(
                new QueryPage<CategorySpecificationTmeplateEntity>().getPage(params),
                new LambdaQueryWrapper<CategorySpecificationTmeplateEntity>()
        );

        return new Pagination(page);
    }

}