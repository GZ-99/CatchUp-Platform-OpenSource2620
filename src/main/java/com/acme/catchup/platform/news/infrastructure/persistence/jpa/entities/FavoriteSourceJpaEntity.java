package com.acme.catchup.platform.news.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "favorite_source", uniqueConstraints = @UniqueConstraint(name = "uk_favorite_source_news_api_key_source_id", columnNames = {"news_api_key", "source_id"}))
public class FavoriteSourceJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "news_api_key", nullable = false, length = 256)
    private String newsApiKey;
    @Column(name = "source_id", nullable = false, length = 256)
    private String sourceId;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected FavoriteSourceJpaEntity() {
    }

    public FavoriteSourceJpaEntity(Long id, String key, String source, Instant created, Instant updated) {
        this.id = id;
        newsApiKey = key;
        sourceId = source;
        createdAt = created;
        updatedAt = updated;
    }

    public Long getId() {
        return id;
    }

    public String getNewsApiKey() {
        return newsApiKey;
    }

    public String getSourceId() {
        return sourceId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
