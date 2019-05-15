package com.tfx0one.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.api.R;
import com.tfx0one.common.utils.HttpContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
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


/*
 * @Auth 2fx0one
 * 22/1/2019 21:24
 */
public class AuthFilter extends BasicHttpAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String token = httpRequest.getHeader(AUTHORIZATION_HEADER);

        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter(AUTHORIZATION_HEADER);
        }

        return token;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);

        if (StringUtils.isBlank(token)) {
            return null;
        }

        return new AuthToken(token);
    }

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含Authorization字段即可
     */

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(AUTHORIZATION_HEADER);
        return authorization != null && !authorization.trim().equals("");
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader(AUTHORIZATION_HEADER);

        AuthToken token = new AuthToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token); //触发 Realm 的 doGetAuthenticationInfo
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
        if (isLoginAttempt(request, response)) { //判断用户是否想要登入。 检测header里面是否包含Authorization字段即可
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return true;
    }
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
//            return true;
//        }
//
//        return true;
//    }

//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        //获取请求token，如果token不存在，直接返回401
//        String token = getRequestToken((HttpServletRequest) request);
//        if (StringUtils.isBlank(token)) {
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//            httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
//
//            String json = JSONObject.toJSONString(R.error(HttpStatus.UNAUTHORIZED.value(), "invalid token, Access Denied"));
//
//            httpResponse.getWriter().print(json);
//
//            return true;
//        }
//
//        return executeLogin(request, response);
//    }

//    @Override
//    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.setContentType("application/json;charset=utf-8");
//        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
//        try {
//            //处理登录失败的异常
//            Throwable throwable = e.getCause() == null ? e : e.getCause();
//            R r = R.error(HttpStatus.UNAUTHORIZED.value(), "LoginFailure" + throwable.getMessage());
//
//            String json = JSONObject.toJSONString(r);
//            httpResponse.getWriter().print(json);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//
//        }
//
//        return false;
//    }

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
            logger.error(e.getMessage(), e);
            return false;
        }
    }

//    private void errorStrWriteToResponse(HttpServletResponse response, AuthenticationException e) throws IOException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        response.getWriter().println(JSONObject.toJSONString(R.error(50000, "error"+e.getMessage())));
//    }

}
