package com.tfx0one.common.util;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * Created by 2fx0one on 28/5/2018.
 * TODE 需要重写缓存配置
 */
public class CacheUtils {

    private static CacheManager cacheManager = SpringContextHolder.getBean(EhCacheCacheManager.class);

    private static String sysDefaultCache = "sysDefaultCache";

    private static Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            throw new RuntimeException("当前系统中没有定义“" + cacheName + "”这个缓存。");
        }
        return cache;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) get(sysDefaultCache, key);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String cacheName, String key) {
        Cache.ValueWrapper valueWrapper = getCache(cacheName).get(key);
        return null == valueWrapper ? null : (T) valueWrapper.get();
    }

    public static void put(String key, Object value) {
        put(sysDefaultCache, key, value);
    }

    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key, value);
    }

    public static void remove(String key) {
        remove(sysDefaultCache, key);

    }

    public static void remove(String cacheName, String key) {
        getCache(cacheName).evict(key);
    }

    public static void clear(String cacheName, String key) {
        getCache(cacheName).clear();
    }

}
