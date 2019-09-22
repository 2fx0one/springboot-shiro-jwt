package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌表，一个品牌下有多个商品（spu），一对多关系
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-09-22 23:17:30
 */
public interface BrandService extends IService<BrandEntity> {

    Pagination<BrandEntity> queryPage(Map<String, Object> params);
}

