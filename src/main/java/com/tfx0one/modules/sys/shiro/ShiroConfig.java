package com.tfx0one.modules.sys.shiro;

import com.tfx0one.modules.sys.shiro.AuthFilter;
import com.tfx0one.modules.sys.shiro.ShiroAuthRealm;
import com.tfx0one.modules.sys.shiro.ShiroRedisCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/*
 * @Auth 2fx0one
 * 22/1/2019 21:21
 */
@Configuration
public class ShiroConfig {

    //身份验证缓存
    public static final String AUTHENTICATION_CACHE_NAME = "C";

    //权限验证缓存
    public static final String AUTHORIZATION_CACHE_NAME = "Z";

    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManagerAuthFilter
     * 可见securityManager是整个shiro的核心；
     *
     * @return
     */
//    @Bean
//    public EhCacheManager ehCacheManager() {
//        EhCacheManager cacheManager = new EhCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
//        return cacheManager;
//    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(ShiroAuthRealm shiroAuthRealm, ShiroRedisCacheManager cacheManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        //缓存
        manager.setCacheManager(cacheManager);

        //自己的 customShiroRealm
        shiroAuthRealm.setAuthenticationCacheName(AUTHENTICATION_CACHE_NAME);
        shiroAuthRealm.setAuthorizationCacheName(AUTHORIZATION_CACHE_NAME);
        shiroAuthRealm.setAuthenticationCachingEnabled(true);
        manager.setRealm(shiroAuthRealm);

        //关闭 shiro session
        // http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);

        manager.setSubjectDAO(subjectDAO);


        return manager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("AuthFilter", new AuthFilter());
        factoryBean.setFilters(filterMap);

        factoryBean.setSecurityManager(securityManager);
        //自定义URL
        Map<String, String> rule = new HashMap<>();
        rule.put("/webjars/**", "anon");
        rule.put("/druid/**", "anon");
        rule.put("/app/**", "anon");
        rule.put("/sys/login", "anon");
        rule.put("/swagger/**", "anon");
        rule.put("/v2/api-docs", "anon");
        rule.put("/swagger-ui.html", "anon");
        rule.put("/swagger-resources/**", "anon");
        rule.put("/captcha.jpg", "anon");
        rule.put("/aaa.txt", "anon");
        rule.put("/**", "AuthFilter");


        factoryBean.setFilterChainDefinitionMap(rule);

        return factoryBean;
    }


    // 自动代理所有的advisor: 由Advisor决定对哪些类的方法进行AOP代理。
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
