package com.acme.catchup.platform.news.domain.model.aggregates;

import com.acme.catchup.platform.news.domain.model.valueobjects.NewsApiKey;
import com.acme.catchup.platform.news.domain.model.valueobjects.SourceId;
import com.acme.catchup.platform.news.domain.model.events.FavoriteSourceCreatedEvent;
import com.acme.catchup.platform.shared.domain.aggregates.AbstractDomainAggregateRoot;

import java.time.Instant;
import java.util.Objects;

/**
 * Pure domain aggregate: no ORM, Spring or transport dependencies.
 */
public final class FavoriteSource extends AbstractDomainAggregateRoot {
    private final Long id;
    private final NewsApiKey newsApiKey;
    private final SourceId sourceId;
    private final Instant createdAt;
    private final Instant updatedAt;

    private FavoriteSource(Long id, NewsApiKey newsApiKey, SourceId sourceId,
                           Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.newsApiKey = Objects.requireNonNull(newsApiKey);
        this.sourceId = Objects.requireNonNull(sourceId);
        this.createdAt = Objects.requireNonNull(createdAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }

    public static FavoriteSource create(NewsApiKey key, SourceId sourceId, Instant now) {
        var favorite = new FavoriteSource(null, key, sourceId, now, now);
        favorite.registerEvent(new FavoriteSourceCreatedEvent(sourceId.value(), now));
        return favorite;
    }

    public static FavoriteSource rehydrate(Long id, NewsApiKey key, SourceId sourceId, Instant createdAt, Instant updatedAt) {
        if (id == null || id <= 0) throw new IllegalArgumentException("Invalid favorite source id");
        return new FavoriteSource(id, key, sourceId, createdAt, updatedAt);
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
