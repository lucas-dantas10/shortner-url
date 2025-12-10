package br.com.shortener_url.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("url")
public class UrlJpaEntity {

    @PrimaryKey("shortcode")
    private String id;

    @Column("long_url")
    private String longUrl;

    @Column("created_at")
    private LocalDateTime createdAt;
}
