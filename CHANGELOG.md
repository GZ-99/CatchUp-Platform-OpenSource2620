 Changelog

Notable changes to Catch-Up Platform are documented here.

This changelog follows [Keep a Changelog](https://keepachangelog.com/en/1.1.0/)
and the project uses [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
Entries describe user-visible behavior and operationally significant changes;
routine implementation details belong in commit history.

## [1.0.1] - 2026-10-15

### Added

- Architecture Decision Records in [`docs/adrs.md`](docs/adrs.md).
- Contributor guidance in [`CONTRIBUTING.md`](CONTRIBUTING.md).
- Changelog documentation in [`CHANGELOG.md`](CHANGELOG.md).

### Changed

- Updated the container build and runtime images to Java 27, using Maven 3.10.0
  with Eclipse Temurin for the build stage.
- Updated setup documentation for Java 27, Spring Boot 4.1.1, and Maven 3.10.0.
- Documented the current architecture in the class diagram and README.

### Security

- Upgraded embedded Apache Tomcat to 11.0.27 to include fixes for reported
  vulnerabilities affecting 11.0.25.
- Redacted News API keys in application logs, retaining only their final four
  characters for correlation.

## Release process

For each release, move the completed unreleased entries under a version heading
with its release date (for example, `## [1.0.0] - YYYY-MM-DD`). Group changes
under `Added`, `Changed`, `Deprecated`, `Removed`, `Fixed`, and `Security` as
applicable. Keep entries concise and focused on their impact to users or
operators. Do not create a release entry until that version is actually
released.
