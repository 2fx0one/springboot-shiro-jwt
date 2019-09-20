package com.tfx0one.modules.sys.controller;

import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSysController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getCurrentSysUser();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
