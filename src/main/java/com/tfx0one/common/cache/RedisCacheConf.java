package com.tfx0one.common.cache;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;


/**
 * Created by 2fx0one on 2018/6/12.
 */
@EnableCaching
@Configuration
public class RedisCacheConf extends CachingConfigurerSupport {

    @SuppressWarnings("unchecked")
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate") //仅仅在当前上下文中不存在某个对象时，才会实例化一个Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

//        System.out.println("++++++++++++ redisTemplate +++++++++++");

        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setConnectionFactory(factory);
        return template;
    }


//    @Bean
//    public RedisCacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
//        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
//        // 开启使用缓存名称最为key前缀
//        redisCacheManager.setUsePrefix(true);
//        //这里可以设置一个默认的过期时间 单位是秒
//        redisCacheManager.setDefaultExpiration(redisDefaultExpiration);
//
//        // 设置缓存的过期时间
//        Map<String, Long> expires = new HashMap<>();
//        expires.put("people", 1000);
//        redisCacheManager.setExpires(expires);
//
//        return redisCacheManager;
//    }
//    缓存管理器
//    @Primary
//    @Bean(name = "redisCacheManager")
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
//                .RedisCacheManagerBuilder
//                .fromConnectionFactory(redisConnectionFactory);
//        return builder.build();
//    }

    //    @Primary
    @SuppressWarnings("unchecked")
    @Bean(name = "redisCacheManager")
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {

            // RedisCache需要一个RedisCacheWriter来实现读写Redis
            RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(redisTemplate.getConnectionFactory());
            // SerializationPair用于Java对象和Redis之间的序列化和反序列化
            // Spring Boot默认采用JdkSerializationRedisSerializer的二进制数据序列化方式
            // 使用该方式，保存在redis中的值是人类无法阅读的乱码，并且该Serializer要求目标类必须实现Serializable接口
            // 本示例中，使用StringRedisSerializer来序列化和反序列化redis的key值
            RedisSerializationContext.SerializationPair keySerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(
                    new StringRedisSerializer());
            // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            RedisSerializationContext.SerializationPair valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(
                    jackson2JsonRedisSerializer);
            // 构造一个RedisCache的配置对象，设置缓存过期时间和Key、Value的序列化机制
            // 这里设置缓存过期时间为1天
            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1))
                    .serializeKeysWith(keySerializationPair).serializeValuesWith(valueSerializationPair);
        System.out.println("==============  Initializing Redis CacheManager ==============");
            return new RedisCacheManager(writer, config);
    }
}
