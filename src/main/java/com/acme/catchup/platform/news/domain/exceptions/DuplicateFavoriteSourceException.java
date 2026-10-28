package com.acme.catchup.platform.news.domain.exceptions;

public class DuplicateFavoriteSourceException extends RuntimeException {
    public DuplicateFavoriteSourceException(Throwable cause) {
        super("Duplicate favorite source", cause);
    }
}
