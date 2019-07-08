package com.tfx0one.common.base;

import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @projectName: base-web
 * @author: wangk
 * @date: 2019/1/23 09:19
 * @Version: 1.0
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return ShiroUtils.getCurrentSysUser();
    }
}
