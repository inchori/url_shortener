package com.smilegate.urlshortener.service;

import com.smilegate.urlshortener.dto.UrlDto;
import com.smilegate.urlshortener.entity.Url;
import com.smilegate.urlshortener.exception.UrlNotFoundException;
import com.smilegate.urlshortener.repository.UrlRepository;
import com.smilegate.urlshortener.utils.Base62Utils;
import com.smilegate.urlshortener.utils.UrlConcat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    private final Base62Utils base62Utils;

    private final UrlConcat urlConcat;

    public UrlDto.urlResponse shortenUrl(String originUrl) {
        Optional<Url> url = urlRepository.findByOriginUrl(originUrl);
        if (url.isPresent()) {
            String shortenUrl = urlConcat.concatHostAndPort(base62Utils.encoding(url.get().getId()));
            return UrlDto.urlResponse.build(originUrl, shortenUrl);
        }

        Url savedUrl = urlRepository.save(Url.shorten(originUrl));
        String shortenUrl = urlConcat.concatHostAndPort(base62Utils.encoding(savedUrl.getId()));
        return UrlDto.urlResponse.build(originUrl, shortenUrl);
    }

    public UrlDto.urlResponse decodeUrl(String shortenUrl) {
        int id = base62Utils.decoding(shortenUrl);
        return UrlDto.urlResponse.build(urlRepository.findById((long) id).get().getOriginUrl(), shortenUrl);
    }

}
