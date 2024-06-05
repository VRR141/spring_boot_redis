package org.example.redis_throughput.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.redis_throughput.dto.PayloadDto;
import org.example.redis_throughput.repository.RedisRepository;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {

    private final RedissonClient redissonClient;
    private final String key = "f6481ea14751";

    @Override
    public String save(PayloadDto val) {
        var id = UUID.randomUUID().toString();
        var bucket = redissonClient.getBucket(getKey(id));
        bucket.set(val);
        return id;
    }

    @Override
    public PayloadDto get(String id) {
        RBucket<PayloadDto> bucket = redissonClient.getBucket(getKey(id));
        return bucket.get();
    }

    private String getKey(String input){
        return key + "_" + input;
    }
}
