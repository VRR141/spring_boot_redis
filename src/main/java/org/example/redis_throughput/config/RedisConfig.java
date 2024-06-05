package org.example.redis_throughput.config;

import org.example.redis_throughput.dto.PayloadDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean("template")
    RedisTemplate<String, PayloadDto> redisTemplate(RedisConnectionFactory connectionFactory, RedisPayloadValueSerializer serializer) {
        var template = new RedisTemplate<String, PayloadDto>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        return template;
    }
}
