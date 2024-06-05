package org.example.redis_throughput.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.redis_throughput.dto.PayloadDto;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class RedisPayloadValueSerializer implements RedisSerializer<PayloadDto> {

    private final ObjectMapper objectMapper;
    private final static PayloadDto empty = new PayloadDto();

    @Override
    @SneakyThrows
    public byte[] serialize(PayloadDto value) throws SerializationException {
        return objectMapper.writeValueAsBytes(value);
    }

    @Override
    @SneakyThrows
    public PayloadDto deserialize(byte[] bytes) throws SerializationException {
        if (Objects.isNull(bytes)) {
            return empty;
        }
        return objectMapper.readValue(bytes, PayloadDto.class);
    }
}
