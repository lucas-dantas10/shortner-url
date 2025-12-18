package br.com.shortener_url.infra.adapter.in.rest.controller;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.domain.usecase.FindUrlByShortUrlUseCase;
import br.com.shortener_url.infra.persistence.UrlJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RedirectUrlAction {

    private final FindUrlByShortUrlUseCase findUrlByShortUrlUseCase;

    @GetMapping("{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable("shortUrl") final String shortUrl) throws URISyntaxException {
        Url url = findUrlByShortUrlUseCase.execute(shortUrl);
        URI uri = new URI(url.getLongUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);

        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }
}
