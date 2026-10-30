package com.acme.catchup.platform.news.domain.model.events;

import com.acme.catchup.platform.shared.domain.events.DomainEvent;

import java.time.Instant;

public record FavoriteSourceCreatedEvent(String sourceId, Instant occurredAt)
        implements DomainEvent {
}
