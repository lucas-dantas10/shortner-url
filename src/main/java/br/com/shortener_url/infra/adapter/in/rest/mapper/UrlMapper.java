package br.com.shortener_url.infra.adapter.in.rest.mapper;

import br.com.shortener_url.domain.model.Url;
import br.com.shortener_url.infra.adapter.in.rest.dto.CreateShortenResponse;

public class UrlMapper {

    public static CreateShortenResponse toCreateShortenResponse(Url url) {
        return new CreateShortenResponse("http://localhost/" + url.getShortcode());
    }
}
