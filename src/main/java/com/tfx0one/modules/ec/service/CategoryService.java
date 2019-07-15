package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface CategoryService extends IService<CategoryEntity> {

    Pagination queryPage(Map<String, Object> params);
}

