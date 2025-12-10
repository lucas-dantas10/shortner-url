package br.com.shortener_url.infra.adapter.out.redis;

import br.com.shortener_url.domain.ports.counter.CounterPort;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCounterAdapter implements CounterPort {

    @Value("${redis.key-counter}")
    private String keyCounter;

    @Value("${redis.init-counter}")
    private String counter;

    private final RedisTemplate<String, String> redisTemplate;

    public RedisCounterAdapter(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        redisTemplate.opsForValue().setIfAbsent(keyCounter, counter);
    }

    public Long increment() {
        return redisTemplate.opsForValue().increment(keyCounter);
    }
}
