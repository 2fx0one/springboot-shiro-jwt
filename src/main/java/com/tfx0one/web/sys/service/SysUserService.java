package com.tfx0one.web.sys.service;

import com.tfx0one.web.sys.entity.SysUser;
import com.tfx0one.common.base.BaseService;
import io.jsonwebtoken.lang.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : 2fx0one
 * @date : 2018/11/7 11:12
 */
@Service
public class SysUserService extends BaseService<SysUser> {

    private final Logger logger = LoggerFactory.getLogger(SysUserService.class);

    @Resource
    private AuthenticationManager authenticationManager;

    public SysUser getByUsername(String username) {
        return this.get(new SysUser().withLoginName(username));
    }

    public SysUser login(String username, String password) {
        Assert.notNull(username, "用户名为空");
        Assert.notNull(password, "密码为空");

        //账号和密码验证
        authenticateUsernameAndPassword(username, password);

        return getByUsername(username);
    }

    //密码验证: authentication 会调用配置好的 UserDetailsService.loadUserByUsername(username)
    //如果密码不正确。会直接throw new RuntimeException. 不再进行接下来的流程。
    private void authenticateUsernameAndPassword(String username, String password) {
        logger.info("密码验证中... UserDetailsService.loadUserByUsername(username)");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
