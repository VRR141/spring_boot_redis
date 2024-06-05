package org.example.redis_throughput.repository;

import org.example.redis_throughput.dto.PayloadDto;

public interface RedisRepository {
    String save(PayloadDto val);
    PayloadDto get(String id);
}
