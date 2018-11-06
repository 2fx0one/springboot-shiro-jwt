package com.tfx0one.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by 2fx0one on 28/5/2018.
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

    private static ApplicationContext applicationContext;

//    @Resource
//    private ProductCenter productCenter;
//
//    @Resource
//    private ImageCenter imageCenter;
//
//    @Resource
//    private CacheUtils cacheUtils;
//
//    @Resource
//    private AccountCenter accountCenter;
//
//    @Value("${is_clear_all_cache_at_startup}")
//    private boolean isClearAllCache;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext; // NOSONAR
//        if (isClearAllCache) {
//            for (Field field : CacheConstant.class.getFields()) {
//                System.out.println("************* Clear Cache ********** " + field.getName());
//                cacheUtils.clear(field.getName());
//            }
//        }
//        imageCenter.cacheImageById();
//        productCenter.refreshAllProductCacheOnce();
//        imageCenter.cacheImageById();
//        productCenter.refreshAllProductCacheOnce();
//        accountCenter.checkDatabaseRoleAndUser();
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }


    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
//        return (T) applicationContext.getBeansOfType(clazz);
        return applicationContext.getBean(clazz);
    }


    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }

    public static String getRootRealPath() {
        String rootRealPath = "";
        try {
            rootRealPath = getApplicationContext().getResource("").getFile().getAbsolutePath();
        } catch (IOException e) {
            logger.warn("获取系统根目录失败");
        }
        return rootRealPath;
    }
}
