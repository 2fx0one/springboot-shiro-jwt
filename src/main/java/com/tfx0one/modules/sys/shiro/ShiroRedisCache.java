package com.tfx0one.modules.sys.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ShiroRedisCache<K, V> implements Cache<K, V> {
    private static final Logger logger = LoggerFactory.getLogger(ShiroRedisCache.class);
    private RedisTemplate<K, V> redisTemplate;
    private final static String PREFIX = "shiro-cache:";
    private String cacheKey;
    private long expire;

//    RedisUtils redisUtils = SpringContextHolder.getBean(RedisUtils.class);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ShiroRedisCache(final String name, final RedisTemplate redisTemplate, long expire) {
        this.expire = expire;
        this.cacheKey = PREFIX + name + ":";
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) throws CacheException {
        logger.debug("Shiro从缓存中获取用户 KEY = [ "+getCacheKey(key)+" ]");
//        redisTemplate.boundValueOps(getCacheKey(key)).expire(expire, TimeUnit.SECONDS);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
//        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return get(key);
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());

    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private K getCacheKey(Object k) {
        return (K) (this.cacheKey + k);
    }
}