package br.com.shortener_url.infra.config;

import br.com.shortener_url.domain.ports.config.UrlConfigProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConfigProviderImpl implements UrlConfigProvider {

    @Value("${hash.salt}")
    private String salt;

    public String getSalt() {
        return salt;
    }
}
