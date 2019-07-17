package com.tfx0one.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.app.entity.CategoryBrandEntity;

import java.util.Map;

/**
 * 商品分类和品牌的中间表，两者是多对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
public interface CategoryBrandService extends IService<CategoryBrandEntity> {

    Pagination queryPage(Map<String, Object> params);
}

