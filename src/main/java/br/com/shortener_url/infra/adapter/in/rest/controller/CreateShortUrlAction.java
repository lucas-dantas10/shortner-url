package br.com.shortener_url.infra.adapter.in.rest.controller;

import br.com.shortener_url.infra.adapter.in.rest.dto.CreateShortenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shorten")
@RequiredArgsConstructor
public class CreateShortUrlAction {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody CreateShortenRequest createShortenRequest) {

    }
}
