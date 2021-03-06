package com.smilegate.urlshortener.controller;

import com.smilegate.urlshortener.dto.UrlDto;
import com.smilegate.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api/shorten")
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    public ResponseEntity<UrlDto.urlResponse> shortenUrl(@RequestBody @Valid UrlDto.urlRequest request) {
        return ResponseEntity.ok().body(urlService.shortenUrl(request.getUrl()));
    }

    @GetMapping("/{shortenUrl}")
    public void redirectUrl(@PathVariable(value = "shortenUrl") String shortenUrl, HttpServletResponse response) throws IOException {
        response.sendRedirect(urlService.decodeUrl(shortenUrl));
    }
}
