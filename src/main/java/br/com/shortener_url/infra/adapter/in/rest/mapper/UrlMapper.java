package br.com.shortener_url.infra.adapter.in.rest.mapper;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.infra.adapter.in.rest.dto.CreateShortenResponse;

public class UrlMapper {

    public static CreateShortenResponse toCreateShortenResponse(String baseUrl, Url url) {
        return new CreateShortenResponse(baseUrl + url.getShortcode());
    }
}
