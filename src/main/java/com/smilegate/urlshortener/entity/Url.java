package com.smilegate.urlshortener.entity;

import com.smilegate.urlshortener.dto.UrlDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "url")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private long id;

    @Column(name = "origin_url")
    private String originUrl;

    public static Url shorten(String originUrl) {
        return Url.builder()
                .originUrl(originUrl)
                .build();
    }
}
