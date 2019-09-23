package com.tfx0one.modules.sys.controller;

import com.tfx0one.common.annotation.SysLog;
import com.tfx0one.common.constant.GlobalConstant;
import com.tfx0one.common.utils.Pagination;
import com.tfx0one.common.utils.R;
import com.tfx0one.common.validator.Assert;
import com.tfx0one.common.validator.ValidatorUtils;
import com.tfx0one.common.validator.group.AddGroup;
import com.tfx0one.common.validator.group.UpdateGroup;
import com.tfx0one.modules.sys.entity.SysUserEntity;
import com.tfx0one.modules.sys.service.ShiroService;
import com.tfx0one.modules.sys.service.SysUserRoleService;
import com.tfx0one.modules.sys.service.SysUserService;
import com.tfx0one.modules.sys.vo.RequestPassword;
import com.tfx0one.modules.sys.vo.ResponseUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/sys/test")
//@RequiresAuthentication
public class SysTestController extends AbstractBaseController {

	@GetMapping("/a")
	@RequiresPermissions("sys:user:delete")
	@ApiOperation(value = "a")
	public R a() {
		return R.ok(getUser());
	}

	@GetMapping("/b")
	@ApiOperation(value = "b")
	public R b() {
		return R.ok("bbbbb");
	}
	@GetMapping("/c")
	@ApiOperation(value = "c")
	public R c() {
		return R.ok("ccccc");
	}
}
