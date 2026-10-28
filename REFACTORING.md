# DDD / SOLID refactoring

- Domain is plain Java: aggregate, value objects, event types, repository port.
- CQRS request types are in Application, with separate command and query services.
- Application depends on the domain repository interface, not JPA.
- Infrastructure contains a JPA entity, Spring Data repository, persistence mapper, adapter, and Clock bean.
- REST contract `/api/v1/favorite-sources` is preserved.
- Duplicate handling: pre-check plus database unique constraint, translated at the persistence adapter boundary. Other integrity errors are rethrown.
- Domain event is registered on creation; it is **not published**. A dispatcher/outbox can be added once the delivery semantics are defined. Persisting the aggregate does not automatically publish events.
- `docs/legacy-tests/` holds tests tied to the old architecture, for reference. They must be rewritten before claiming complete regression coverage.
- This package was not Maven-tested in the authoring environment because Maven is not installed. Run `mvn clean test` with Java 21 and a MySQL integration test profile.
- DB schema is intended to preserve `favorite_source` and its columns; check migration against your current schema before deployment.
- Security note: API key remains in GET query strings and API responses to preserve compatibility. Avoid real credentials there; plan a breaking change to move to authenticated identity or header-based credentials.
