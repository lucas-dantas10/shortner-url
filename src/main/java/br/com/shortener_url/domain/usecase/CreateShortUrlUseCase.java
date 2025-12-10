package br.com.shortener_url.domain.usecase;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.domain.ports.config.UrlConfigProvider;
import br.com.shortener_url.domain.ports.counter.CounterPort;
import br.com.shortener_url.domain.ports.repository.UrlRepository;

public class CreateShortUrlUseCase {

    private final UrlRepository urlRepository;
    private final UrlConfigProvider urlConfigProvider;
    private final CounterPort counterPort;

    public CreateShortUrlUseCase(UrlRepository urlRepository, UrlConfigProvider urlConfigProvider, CounterPort counterPort) {
        this.urlRepository = urlRepository;
        this.urlConfigProvider = urlConfigProvider;
        this.counterPort = counterPort;
    }

    public Url execute(String longUrl) {
        Url url = new Url(longUrl, counterPort.increment(), urlConfigProvider.getSalt());

        return urlRepository.save(url);
    }
}
