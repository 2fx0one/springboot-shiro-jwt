package com.tfx0one.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	Pagination queryPage(Map<String, Object> params);
	
}
