package com.acme.catchup.platform.news.domain.model.valueobjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewsApiKeyTest {
    @Test
    void masksKeyAndExposesOnlyLastFourCharacters() {
        assertEquals("****wxyz", new NewsApiKey("secret-wxyz").maskedForLogging());
    }

    @Test
    void masksShortKeyCompletely() {
        assertEquals("****", new NewsApiKey("abcd").maskedForLogging());
    }
}
