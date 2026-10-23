package com.acme.hello.platform.news.domain.model.aggregates;

import com.acme.hello.platform.news.domain.model.valueobjects.NewsApiKey;
import com.acme.hello.platform.news.domain.model.valueobjects.SourceId;

import java.time.Instant;
import java.util.Objects;

public final class FavoriteSource {
    private final Long id;
    private final NewsApiKey newsApiKey;
    private final SourceId sourceId;
    private final Instant createAt;
    private final Instant updatedAt;

    public FavoriteSource(Long id, NewsApiKey newsApiKey, SourceId sourceId, Instant createAt, Instant updatedAt) {
        this.id = id;
        this.newsApiKey = Objects.requireNonNull(newsApiKey);
        this.sourceId = Objects.requireNonNull(sourceId);
        this.createAt = Objects.requireNonNull(createAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }

    public static FavoriteSource create(NewsApiKey key, SourceId sourceId, Instant now) {
        var favorite = new FavoriteSource(null, key, sourceId, now, now);
        return favorite;
    }

    public static FavoriteSource rehyDrate(Long id, NewsApiKey newsApiKey, SourceId sourceId, Instant createAt, Instant updatedAt) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid favorite source id");
        }
        return new FavoriteSource(id, newsApiKey, sourceId, createAt, updatedAt);
    }

    public Long getId() {
        return id;
    }

    public NewsApiKey getNewsApiKey() {
        return newsApiKey;
    }

    public SourceId getSourceId() {
        return sourceId;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
