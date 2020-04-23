package com.tfx0one.modules.sys.service.impl;

import com.tfx0one.modules.sys.dao.SysDeptDao;
import com.tfx0one.modules.sys.entity.SysDeptEntity;
import com.tfx0one.modules.sys.service.SysDeptService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.Query;


@Service("deptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Override
    public Pagination<SysDeptEntity> queryPage(Map<String, Object> params, SysDeptEntity dept) {
        IPage<SysDeptEntity> page = this.page(
                Query.page(params),
                Wrappers.<SysDeptEntity>lambdaQuery()
        );

        return Pagination.create(page);
    }

}