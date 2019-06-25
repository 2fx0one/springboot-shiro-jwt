package com.tfx0one.common.base;

import com.tfx0one.common.utils.ShiroUtils;
import com.tfx0one.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
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

    protected SysUser getUser() {
        return ShiroUtils.getCurrentSysUser();
    }
}
