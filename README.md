# cedar-examples

Spring Boot apps and platform manifests laid out for [Cedar](https://github.com/somayaj/cedar) reviews.

Cedar slices a pull request by path (`components.yaml`): domain, application, infrastructure, API, runtime config, build, and platform (Terraform, Kubernetes, GitHub Actions).

| App | Role | Port |
|-----|------|------|
| `payment-gateway` | Payments | `${PORT:8081}` |
| `notification-hub` | Notifications | `${PORT:8082}` |

`main` is the health-only baseline. Review these pull requests in Cedar:

| PR | What it changes | Cedar slices |
|----|-----------------|--------------|
| [#1](https://github.com/asomayajula-cn/cedar-examples/pull/1) | Checkout session API in payment-gateway | domain, application, infrastructure, API, config, build |
| [#2](https://github.com/asomayajula-cn/cedar-examples/pull/2) | Email send API in notification-hub | domain, application, infrastructure, API, config, build |
| [#3](https://github.com/asomayajula-cn/cedar-examples/pull/3) | Deploy payment-gateway | platform (Terraform, Kubernetes, Docker, Actions) |
| [#4](https://github.com/asomayajula-cn/cedar-examples/pull/4) | Deploy notification-hub | platform (Terraform, Kubernetes, Docker, Actions) |

```bash
mvn -q -pl payment-gateway spring-boot:run
mvn -q -pl notification-hub spring-boot:run
```

Health: `GET /api/health`.
