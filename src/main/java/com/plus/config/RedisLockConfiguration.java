package com.plus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @Author: AI
 * @Date: 2019/12/25 17:26
 * @Version: 1.0
 */
@Configuration
public class RedisLockConfiguration {
    @Bean
    public RedisLockRegistry redisLockRegistry(
            RedisConnectionFactory redisConnectionFactory) {
        // 注意这里的时间单位是毫秒
        return new RedisLockRegistry(redisConnectionFactory, "registryKey", 60L);
    }
}
