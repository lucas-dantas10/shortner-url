package br.com.shortener_url.infra.adapter.in.rest.controller;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.domain.usecase.CreateShortUrlUseCase;
import br.com.shortener_url.infra.adapter.in.rest.dto.CreateShortenRequest;
import br.com.shortener_url.infra.adapter.in.rest.dto.CreateShortenResponse;
import br.com.shortener_url.infra.adapter.in.rest.mapper.UrlMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shorten")
@RequiredArgsConstructor
public class CreateShortUrlAction {

    private final CreateShortUrlUseCase createShortUrlUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateShortenResponse> create(
            @RequestBody CreateShortenRequest createShortenRequest,
            HttpServletRequest request) {
        Url url = createShortUrlUseCase.execute(createShortenRequest.longUrl());

        String baseUrl = request.getRequestURL()
                .toString()
                .replace(request.getRequestURI(), "");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UrlMapper.toCreateShortenResponse(baseUrl, url));
    }
}
