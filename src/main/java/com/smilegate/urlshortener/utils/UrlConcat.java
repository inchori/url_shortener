package com.smilegate.urlshortener.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConcat {

    public String concatHostAndPort(String path) {
        return "http://localhost:8080/" + path;
    }
}
