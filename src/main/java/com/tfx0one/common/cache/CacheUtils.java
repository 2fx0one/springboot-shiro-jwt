package com.tfx0one.common.cache;

import com.tfx0one.common.util.SpringContextHolder;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 28/5/2018.
 * TODE 需要重写缓存配置
 */
public class CacheUtils {

    private boolean isUseRedis = false;

    private static CacheManager cacheManager = SpringContextHolder.getBean("ehCacheCacheManager");

    private static Cache getCache(String cacheName) {
        return cacheManager.getCache(cacheName);
    }

    public static Object get(String cacheName, String key) {
        Cache.ValueWrapper valueWrapper = getCache(cacheName).get(key);
        return null == valueWrapper ? null : valueWrapper.get();
    }

    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key, value);
    }
}
