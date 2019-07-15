package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.SkuEntity;

import java.util.Map;

/**
 * sku表,该表表示具体的商品实体,如黑色的 64g的iphone 8
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface SkuService extends IService<SkuEntity> {

    Pagination queryPage(Map<String, Object> params);
}

