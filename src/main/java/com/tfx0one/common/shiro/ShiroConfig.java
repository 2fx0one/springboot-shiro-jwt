package com.tfx0one.common.shiro;

import org.apache.shiro.cache.ehcache.EhCacheManager;
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
    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     *
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(CustomRealm customRealm, EhCacheManager cacheManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        //自己的 customRealm
        manager.setRealm(customRealm);

        manager.setCacheManager(cacheManager);

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
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JWTFilter());
        factoryBean.setFilters(filterMap);

        factoryBean.setSecurityManager(securityManager);
        factoryBean.setUnauthorizedUrl("/401");

        //自定义URL
        Map<String, String> filterRuleMap = new HashMap<>();
        //所有请求都要过jwt
        filterRuleMap.put("/**", "jwt");
        //401 页面不需要
        filterRuleMap.put("/login", "anon");
        filterRuleMap.put("/401", "anon");
        filterRuleMap.put("/404", "anon");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);

        return factoryBean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //注解支持
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
