package br.com.shortener_url.domain.usecase;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.domain.ports.repository.UrlRepository;

public class FindUrlByShortUrlUseCase {

    private final UrlRepository urlRepository;

    public FindUrlByShortUrlUseCase(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url execute(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }
}
