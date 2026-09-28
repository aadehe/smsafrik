# Enterprise Notification Platform

A cloud-native notification platform designed to demonstrate reliable, event-driven backend and platform engineering.

The initial business use case is financial transaction notifications delivered through SMS. The architecture is intentionally designed so additional notification channels can be introduced without coupling the core domain to a specific provider.

## Engineering goals

- Reliable asynchronous notification processing
- Transactional persistence and event publication
- Idempotent processing under at-least-once delivery
- Bounded retry and dead-letter handling
- Provider abstraction and failure isolation
- Secure handling of notification data
- Production-oriented observability
- Containerized local development
- Kubernetes deployment
- Infrastructure as Code
- Automated CI/CD

## Current status

This repository is currently at **Milestone 0 — Foundation**.

| Capability | Status |
|---|---|
| Repository architecture | In progress |
| Kotlin/Ktor application | Planned |
| PostgreSQL persistence | Planned |
| Transactional outbox | Planned |
| Kafka event processing | Planned |
| Idempotency | Planned |
| Retry / DLQ | Planned |
| Observability | Planned |
| Security hardening | Planned |
| Kubernetes | Planned |
| Terraform / AWS | Planned |
| CI/CD | Planned |

The project status is deliberately kept aligned with implemented code.

## Architecture

The target architecture is:

```text
                         +----------------------+
                         | Transaction System   |
                         +----------+-----------+
                                    |
                                    v
                         +----------------------+
                         | Notification API     |
                         | Kotlin + Ktor        |
                         +----------+-----------+
                                    |
                         +----------v-----------+
                         | PostgreSQL            |
                         | notifications         |
                         | outbox_events         |
                         | attempts              |
                         +----------+-----------+
                                    |
                             Transactional
                                Outbox
                                    |
                                    v
                         +----------------------+
                         | Kafka                |
                         | events / retry / DLQ |
                         +----------+-----------+
                                    |
                                    v
                         +----------------------+
                         | Notification Worker  |
                         +----------+-----------+
                                    |
                                    v
                         +----------------------+
                         | Provider Adapter     |
                         +----------+-----------+
                                    |
                                    v
                         +----------------------+
                         | External SMS Gateway |
                         +----------------------+
```

## Repository structure

```text
smsafrik/
├── .github/
│   └── workflows/
├── docs/
│   ├── architecture/
│   ├── adr/
│   ├── runbooks/
│   └── testing/
├── services/
│   └── notification/
│       └── src/
├── infrastructure/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── docker-compose.yml
└── README.md
```

## Development principles

1. Implement before claiming.
2. Prefer simple boundaries that solve real problems.
3. Keep domain logic independent of infrastructure.
4. Treat PostgreSQL as authoritative application state.
5. Treat Kafka delivery as at-least-once.
6. Design for failure, not only the happy path.
7. Never log secrets or unnecessary financial data.
8. Test behavior and failure modes.
9. Document significant architectural decisions.
10. Keep every milestone cumulative and runnable.

## Roadmap

- Milestone 0 — Foundation
- Milestone 1 — Notification Domain and API
- Milestone 2 — PostgreSQL Persistence
- Milestone 3 — Transactional Outbox
- Milestone 4 — Kafka and Notification Worker
- Milestone 5 — Reliability
- Milestone 6 — Observability
- Milestone 7 — Security
- Milestone 8 — Containerized Platform
- Milestone 9 — Kubernetes
- Milestone 10 — CI/CD
- Milestone 11 — Terraform and AWS
- Milestone 12 — Production Hardening
