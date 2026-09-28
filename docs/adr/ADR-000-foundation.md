# ADR-000: Repository and Service Foundation

## Status

Accepted

## Context

The project is intended to demonstrate both backend engineering and DevOps/platform engineering. The repository therefore needs to support incremental growth without introducing unnecessary microservice boundaries.

## Decision

Use a Gradle multi-module repository with the notification service as the first deployable component.

Keep the initial service internally modular using API, application, domain, and infrastructure boundaries.

Do not create a separate authentication service until a real domain or operational requirement justifies that boundary.

## Consequences

### Positive

- Clear ownership boundaries.
- Easy local development.
- Incremental introduction of Kafka, PostgreSQL, Kubernetes, and cloud infrastructure.
- Avoids premature distributed-system complexity.

### Trade-off

The repository is intentionally not a collection of independently deployable services at the beginning. Service extraction will be considered only when justified by the domain and operational requirements.
