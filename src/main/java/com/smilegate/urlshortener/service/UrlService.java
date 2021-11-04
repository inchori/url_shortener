package com.smilegate.urlshortener.service;

import com.smilegate.urlshortener.dto.UrlDto;
import com.smilegate.urlshortener.entity.Url;
import com.smilegate.urlshortener.repository.UrlRepository;
import com.smilegate.urlshortener.utils.Base62;
import com.smilegate.urlshortener.utils.UrlConcat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final Base62 base62;
    private final UrlConcat urlConcat;

    public UrlDto.urlResponse shortenUrl(String originUrl) {
        Optional<Url> url = urlRepository.findByOriginUrl(originUrl);
        if (url.isPresent()) {
            String shortenUrl = urlConcat.concatHostAndPort(base62.encoding(url.get().getId()));
            return UrlDto.urlResponse.build(originUrl, shortenUrl);
        }

        Url savedUrl = urlRepository.save(Url.shorten(originUrl));
        String shortenUrl = urlConcat.concatHostAndPort(base62.encoding(savedUrl.getId()));
        return UrlDto.urlResponse.build(originUrl, shortenUrl);
    }

    public String decodeUrl(String shortenUrl) {
        long id = base62.decoding(shortenUrl);
        return urlRepository.findById(id).get().getOriginUrl();
    }

}
