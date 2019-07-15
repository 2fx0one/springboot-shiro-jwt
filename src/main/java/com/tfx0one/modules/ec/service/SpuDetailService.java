package com.tfx0one.modules.ec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.ec.entity.SpuDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
public interface SpuDetailService extends IService<SpuDetailEntity> {

    Pagination queryPage(Map<String, Object> params);
}

