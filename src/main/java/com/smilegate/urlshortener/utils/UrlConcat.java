package com.smilegate.urlshortener.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConcat {

    @Value(value = "${server.host}")
    private String host;

    @Value(value = "${server.port}")
    private String port;

    public String concatHostAndPort(String path) {
        return "http://" + host + ":" + port + "/" + path;
    }
}
