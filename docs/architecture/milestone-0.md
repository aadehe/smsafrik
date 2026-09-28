# Milestone 0 — Foundation

## Purpose

Milestone 0 establishes the engineering foundation for the Enterprise Notification Platform before business functionality is introduced.

## Decisions

### Build model

The repository uses a Gradle multi-module structure.

The first deployable component is:

```text
services/notification
```

This leaves room for additional deployables without prematurely creating multiple business services.

### Application architecture

The notification service will follow:

```text
API
 ↓
Application
 ↓
Domain
 ↓
Infrastructure
```

Dependencies should point inward. Domain code must not depend directly on Ktor, PostgreSQL, Kafka, or an external SMS provider.

### Runtime

The initial runtime target is Java 21.

### Health endpoints

The service exposes:

- `GET /health/live`
- `GET /health/ready`

The readiness endpoint will become dependency-aware when PostgreSQL and Kafka are introduced.

## Exit criteria

Milestone 0 is complete when:

- the repository has the agreed structure;
- the notification service builds through Gradle;
- the application starts;
- health endpoints respond;
- automated tests execute;
- Docker packaging is defined;
- CI validates the project;
- architecture decisions are documented.
