package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.SpuEntity;

import java.util.Map;

/**
 * spu表，该表描述的是一个抽象性的商品，比如 iphone8
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface SpuService extends IService<SpuEntity> {

    Pagination queryPage(Map<String, Object> params);
}

