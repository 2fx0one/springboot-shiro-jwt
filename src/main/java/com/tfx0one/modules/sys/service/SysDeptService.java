package com.tfx0one.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.sys.entity.SysDeptEntity;

import java.util.Map;

/**
 * 部门管理
 *
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2020-04-14 17:30:08
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    Pagination<SysDeptEntity> queryPage(Map<String, Object> params, SysDeptEntity dept);
}

