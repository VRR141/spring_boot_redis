package org.example.redis_throughput.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.redis_throughput.dto.PayloadDto;
import org.example.redis_throughput.repository.RedisRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {

    private final RedisTemplate<String, PayloadDto> template;
    private final String key = "f6481ea14751";

    @Override
    public String save(PayloadDto val) {
        var id = UUID.randomUUID().toString();
        template.opsForValue().set(getKey(id), val);
        return id;
    }

    @Override
    public PayloadDto get(String id) {
        return template.opsForValue().get(getKey(id));
    }

    private String getKey(String input){
        return key + "_" + input;
    }
}
