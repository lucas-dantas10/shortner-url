package br.com.shortener_url.infra.config;

import br.com.shortener_url.domain.usecase.CreateShortUrlUseCase;
import br.com.shortener_url.infra.adapter.out.redis.RedisCounterAdapter;
import br.com.shortener_url.infra.persistence.UrlRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateShortUrlUseCase createShortUrlUseCase(
            UrlRepositoryImpl urlRepository,
            UrlConfigProviderImpl urlConfigProvider,
            RedisCounterAdapter redisCounterAdapter
    ) {
        return new CreateShortUrlUseCase(urlRepository, urlConfigProvider, redisCounterAdapter);
    }
}
