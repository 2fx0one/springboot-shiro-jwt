package com.tfx0one.sys.controller;

import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getCurrentSysUser();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
