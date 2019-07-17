package com.tfx0one.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.app.entity.CategorySpecificationTemplateEntity;

import java.util.Map;

/**
 * 商品规格参数模板，json格式。
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-17 17:42:40
 */
public interface CategorySpecificationTemplateService extends IService<CategorySpecificationTemplateEntity> {

    Pagination queryPage(Map<String, Object> params);
}

