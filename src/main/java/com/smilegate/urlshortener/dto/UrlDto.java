package com.smilegate.urlshortener.dto;

import com.smilegate.urlshortener.entity.Url;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

public class UrlDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class urlRequest {
        @URL(message = "Invalid URL Format")
        @NotEmpty(message = "Not null")
        private String url;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class urlResponse {
        private String originUrl;
        private String shortenUrl;

        public static UrlDto.urlResponse build(String originUrl, String shortenUrl) {
            return urlResponse.builder()
                    .originUrl(originUrl)
                    .shortenUrl(shortenUrl)
                    .build();
        }
    }
}
