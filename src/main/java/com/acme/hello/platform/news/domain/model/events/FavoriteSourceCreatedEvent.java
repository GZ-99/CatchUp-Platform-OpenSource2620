package com.acme.hello.platform.news.domain.model.events;

import com.acme.hello.platform.shared.domain.model.events.DomainEvent;

import java.time.Instant;

public record FavoriteSourceCreatedEvent(String sourceId, Instant ocurredAt) implements DomainEvent {
}
