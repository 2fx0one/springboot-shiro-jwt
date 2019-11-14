package com.tfx0one.common.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author 2fx0one
 * @version 1.0
 * @createDate 2019-11-14 15:17
 * @projectName springboot-shiro-jwt
 */

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean(name = "redisTemplate")
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //使用fastjson序列化

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //获得redis缓存管理类
        return RedisCacheManager.create(redisConnectionFactory);
        // 开启使用缓存名称做为key前缀(这样所有同名缓存会整理在一起比较容易查找)
    }

}
