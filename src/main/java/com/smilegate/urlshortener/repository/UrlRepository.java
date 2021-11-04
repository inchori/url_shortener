package com.smilegate.urlshortener.repository;

import com.smilegate.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByOriginUrl(String url);
}
