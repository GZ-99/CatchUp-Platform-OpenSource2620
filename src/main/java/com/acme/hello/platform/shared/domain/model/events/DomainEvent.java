package com.acme.hello.platform.shared.domain.model.events;

import java.time.Instant;

public interface DomainEvent {
    Instant ocurredAt();
}
