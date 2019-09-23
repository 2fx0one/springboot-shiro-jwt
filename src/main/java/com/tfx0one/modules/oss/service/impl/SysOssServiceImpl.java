package com.tfx0one.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.QueryPage;
import com.tfx0one.modules.oss.dao.SysOssDao;
import com.tfx0one.modules.oss.entity.SysOssEntity;
import com.tfx0one.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public Pagination queryPage(Map<String, Object> params) {
		IPage<SysOssEntity> page = this.page(
			new QueryPage<SysOssEntity>().getPage(params)
		);

		return new Pagination(page);
	}
	
}
