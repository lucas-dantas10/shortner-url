package br.com.shortener_url.domain.ports.repository;

import br.com.shortener_url.domain.model.Url;

public interface UrlRepository {

    Url save(Url url);
}
