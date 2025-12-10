package br.com.shortener_url.infra.persistence;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.domain.ports.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UrlRepositoryImpl implements UrlRepository {

    private final SpringUrlRepository repository;

    public Url save(Url url) {
        UrlJpaEntity urlJpaEntity = new UrlJpaEntity();
        urlJpaEntity.setLongUrl(url.getLongUrl());
        urlJpaEntity.setId(url.getShortcode());
        urlJpaEntity.setCreatedAt(url.getCreatedAt());

        repository.save(urlJpaEntity);

        return url;
    }
}
