package com.tfx0one.common.shiro;

import com.tfx0one.common.constant.GlobalConstant;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShiroRedisCacheManager implements CacheManager {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        //name 是从 shiro Conf 中 shiroAuthRealm 得到
        return new ShiroRedisCache<>(name, redisTemplate, GlobalConstant.JWT_REDIS_EXPIRE_TIME_IN_SECOND);
    }

}
