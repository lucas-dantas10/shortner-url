package br.com.shortener_url.domain.model;

import org.hashids.Hashids;

import java.time.LocalDateTime;

public class Url {

    private static final int MIN_LENGTH_HASH = 3;

    private String shortcode;
    private String longUrl;
    private LocalDateTime createdAt;

    public Url(String longUrl, long counter, String salt) {
        this.shortcode = this.generateShortcode(counter, salt);
        this.longUrl = longUrl;
        this.createdAt = LocalDateTime.now();
    }

    public String getShortcode() {
        return shortcode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private String generateShortcode(long counter, String salt) {
        Hashids hashids = new Hashids(salt, MIN_LENGTH_HASH);

        return hashids.encode(counter);
    }
}
