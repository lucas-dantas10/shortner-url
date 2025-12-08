package br.com.shortener_url.infra.persistence;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SpringUrlRepository extends CassandraRepository<Url, Long> {
}
