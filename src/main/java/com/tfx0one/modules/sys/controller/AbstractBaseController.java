package com.tfx0one.modules.sys.controller;

import com.tfx0one.modules.sys.shiro.ShiroUtils;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getCurrentSysUser();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
