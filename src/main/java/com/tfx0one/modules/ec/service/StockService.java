package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.StockEntity;

import java.util.Map;

/**
 * 库存表，代表库存，秒杀库存等信息
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface StockService extends IService<StockEntity> {

    Pagination queryPage(Map<String, Object> params);
}

