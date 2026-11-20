# cedar-examples

Spring Boot apps and platform manifests laid out for [Cedar](https://github.com/somayaj/cedar) reviews.

Cedar slices a pull request by path (`components.yaml`): domain, application, infrastructure, API, runtime config, build, and platform (Terraform, Kubernetes, GitHub Actions).

| App | Role | Port |
|-----|------|------|
| `payment-gateway` | Payments | `${PORT:8081}` |
| `notification-hub` | Notifications | `${PORT:8082}` |

`main` is the health-only baseline. Review the open pull requests in Cedar — each one is either a Spring Boot feature (several DDD slices) or an infra change for one app (platform slice only).

```bash
mvn -q -pl payment-gateway spring-boot:run
mvn -q -pl notification-hub spring-boot:run
```

Health: `GET /api/health`.
