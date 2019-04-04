package com.tfx0one.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.api.ExceptionResult;
import com.tfx0one.common.api.R;
import com.tfx0one.common.exception.CommonException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tfx0one.common.exception.ExceptionEnum.TOKEN_INVALID;

/*
 * @Auth 2fx0one
 * 22/1/2019 21:24
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    //执行流程preHandle->isAccessAllowed->isLoginAttempt->executeLogin

    private static String TOEKN_HEADER = "Authorization";

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(TOEKN_HEADER);
        return authorization != null && !authorization.trim().equals("");
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader(TOEKN_HEADER);

        JWTToken token = new JWTToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 这里我们详细说明下为什么最终返回的都是true，即允许访问
     * 例如我们提供一个地址 GET /article
     * 登入用户和游客看到的内容是不同的
     * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
     * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            return executeLogin(request, response);
        }
        return true;
    }

    //执行流程preHandle->isAccessAllowed->isLoginAttempt->executeLogin
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        try {
            return super.preHandle(request, response);
        } catch (AuthenticationException e) {
            errorStrWriteToResponse(httpServletResponse, e);
            return false;
        }
    }


    private void errorStrWriteToResponse(HttpServletResponse response, AuthenticationException e) throws IOException {
//        R r = R.error(code, msg);
//        new ObjectMapper().writeValueAsString(R.error(code, msg));
//        String errStr = "{\"code\":" + code + ",\"msg\":\"" + errorCode + "\"}";
        response.setCharacterEncoding("UTF-8");
        response.setStatus(TOKEN_INVALID.getCode());
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(JSONObject.toJSON(new ExceptionResult(TOKEN_INVALID)));
    }
}
