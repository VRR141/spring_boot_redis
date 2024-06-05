package org.example.redis_throughput.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.redis_throughput.dto.PayloadDto;
import org.example.redis_throughput.repository.RedisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payload")
@Slf4j
public class PayloadController {

    private final RedisRepository repository;

    @PostMapping
    public ResponseEntity<String> post(@RequestBody PayloadDto payload){
        return ResponseEntity.ok(repository.save(payload));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayloadDto> get(@PathVariable("id") String id){
        return ResponseEntity.ok(repository.get(id));
    }
}
