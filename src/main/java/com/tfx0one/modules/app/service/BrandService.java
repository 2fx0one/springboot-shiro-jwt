package com.tfx0one.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.app.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:17:04
 */
public interface BrandService extends IService<BrandEntity> {

    Pagination queryPage(Map<String, Object> params);
}

