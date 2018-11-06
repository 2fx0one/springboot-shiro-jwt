package com.tfx0one.common.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 28/5/2018.
 * TODE 需要重写缓存配置
 */
@Component
public class CacheUtils {

    private boolean isUseRedis = false;

    @Resource
    private EhCacheCacheManager ehCacheCacheManager;
    // = SpringContextHolder.getBean("ehCacheCacheManager");

//    @Resource
//    private RedisCacheManager redisCacheManager;

    private Ehcache getEhcache(String cacheName) {
        if (ehCacheCacheManager == null || ehCacheCacheManager.getCacheManager() == null) {
            throw new NullPointerException("CacheManager == null");
        }
        return ehCacheCacheManager.getCacheManager().getEhcache(cacheName);
    }

    //
//    //=============spring包装的缓存管理对象======================
////    //通过spring得到缓存管理对象
//    private Cache getRedisCache(String cacheName) {
//        return redisCacheManager.getCache(cacheName);
//    }


    public void put(String cacheName, Object key, Object value) {
        if (!StringUtils.isEmpty(key)) {
//            if (isUseRedis) {
//                getRedisCache(cacheName).put(key, value);
//            } else {
            Element element = new Element(key, value);
            getEhcache(cacheName).put(element);
//            }
        }
    }

    //ehcache 带时间 时间是秒! 只能是ehcache 使用! 缓存创建以后，最后一次访问缓存的日期至失效之时的时间间隔y；
    public void putToEhcacheWithIdleTime(String cacheName, Object key, Object value, int timeToIdleSeconds) {
        if (!StringUtils.isEmpty(key)) {
            Element element = new Element(key, value);

//            element.setEternal(false);
            element.setTimeToIdle(timeToIdleSeconds);
            getEhcache(cacheName).put(element);
        }
    }

    public void putToEhcacheWithLiveTime(String cacheName, Object key, Object value, int timeToLiveSeconds) {
        if (!StringUtils.isEmpty(key)) {
            Element element = new Element(key, value);

//            element.setEternal(false);
            element.setTimeToLive(timeToLiveSeconds);
            getEhcache(cacheName).put(element);
        }
    }

    //ehcache
    @SuppressWarnings("unchecked")
    public <T> T getEhcacheByKey(String cacheName, Object key) {
        T value = null;
        if (!StringUtils.isEmpty(key)) {

            Element e = getEhcache(cacheName).get(key);
            if (e != null) {
                value = (T) e.getObjectValue();
            }
        }
        return value;
    }

    //    删除一个key对应的缓存
    public boolean removeEhcacheByKey(String cacheName, String key) {

        return getEhcache(cacheName).remove(key);

    }


    @SuppressWarnings("unchecked")
    public <T> T get(String cacheName, Object key) {
        T value = null;
        if (!StringUtils.isEmpty(key)) {
//            if (isUseRedis) {
//                Cache.ValueWrapper val = getRedisCache(cacheName).get(key);
//                if (val != null) {
//                    value = (T) val.get();
//                }
//            } else {
            Element e = getEhcache(cacheName).get(key);
            if (e != null) {
                value = (T) e.getObjectValue();
            }
//            }
        }
        return value;
    }


    //    删除一个key对应的缓存
    public boolean remove(String cacheName, String key) {
//        if (isUseRedis) {
//            getRedisCache(cacheName).evict(key);
        //redis 先返回空。兼容
//            return true;
//        } else {
        return getEhcache(cacheName).remove(key);
//        }
    }

    /**
     * 清空某一个缓存，全部清除
     *
     * @param cacheName
     */
    public void clear(String cacheName) {
//        if (getCache(cacheName) != null) {
//        if (isUseRedis) {
//            getRedisCache(cacheName).clear();
//        } else {
        getEhcache(cacheName).removeAll();
//        }
//        }
    }
//
//
//    /**
//     *
//     * @Description: 删除缓存中的信息
//     */
//    public void evict(String cacheName,String key) {
//        if (!StringUtils.isEmpty(key)) {
//            getCache(cacheName).evict(key);
//        }
//    }


}
