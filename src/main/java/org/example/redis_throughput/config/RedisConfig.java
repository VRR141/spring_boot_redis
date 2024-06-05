package org.example.redis_throughput.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Bean
    RedissonClient client(Config config) {
        return Redisson.create(config);
    }

    @Bean
    Config config(RedisProperties redisProperties) {
        var config = new Config();
        config.useSingleServer()
                .setConnectionPoolSize(8)
                .setConnectionMinimumIdleSize(2)
                .setAddress(redisProperties.getUrl())
                .setPassword(redisProperties.getPassword())
                .setClientName(redisProperties.getClientName());
        return config;
    }
}
