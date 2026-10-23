package com.acme.hello.platform.shared.domain.model.aggregates;

import com.acme.hello.platform.shared.domain.model.events.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDomainAggregateRoot {
    private final List<DomainEvent> pendingEvents = new ArrayList<>();

    protected final void registerEvent(DomainEvent event) {
        pendingEvents.add(event);
    }

    public final List<DomainEvent> pullDomainEvents() {
        var copyEvents = List.copyOf(pendingEvents);
        pendingEvents.clear();
        return copyEvents;
    }
}
