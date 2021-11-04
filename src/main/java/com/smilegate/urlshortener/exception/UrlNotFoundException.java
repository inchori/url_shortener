package com.smilegate.urlshortener.exception;

import javax.persistence.EntityNotFoundException;

public class UrlNotFoundException extends EntityNotFoundException {
    public UrlNotFoundException() {
        super("해당 URL 이 없습니다.");
    }
}
