package com.tfx0one.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * Created by 2fx0one on 2018/6/12.
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {


    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
//setValueSerializer setHashValueSerializer的序列化 使用默认的jdk， 否则报错

    RedisTemplate<String, Object> objRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

//        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
//        redisTemplate.setValueSerializer(serializer);
//        redisTemplate. (serializer);
        // key的序列化采用StringRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }



//    @Primary
//    @SuppressWarnings("unchecked")
//    @Bean(name = "redisCacheManager")
//    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
//
//            // RedisCache需要一个RedisCacheWriter来实现读写Redis
//            RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(Objects.requireNonNull(redisTemplate.getConnectionFactory()));
//            // SerializationPair用于Java对象和Redis之间的序列化和反序列化
//            // Spring Boot默认采用JdkSerializationRedisSerializer的二进制数据序列化方式
//            // 使用该方式，保存在redis中的值是人类无法阅读的乱码，并且该Serializer要求目标类必须实现Serializable接口
//            // 本示例中，使用StringRedisSerializer来序列化和反序列化redis的key值
//            RedisSerializationContext.SerializationPair keySerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(
//                    new StringRedisSerializer());
//            // 使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
//            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper om = new ObjectMapper();
//            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            jackson2JsonRedisSerializer.setObjectMapper(om);
//            RedisSerializationContext.SerializationPair valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(
//                    jackson2JsonRedisSerializer);
//            // 构造一个RedisCache的配置对象，设置缓存过期时间和Key、Value的序列化机制
//            // 这里设置缓存过期时间为1天
//            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1))
//                    .serializeKeysWith(keySerializationPair).serializeValuesWith(valueSerializationPair);
//        System.out.println("==============  Initializing Redis CacheManager ==============");
//            return new RedisCacheManager(writer, config);
//    }
}



