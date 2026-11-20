resource "kubernetes_deployment_v1" "notification_hub" {
  metadata {
    name      = "notification-hub"
    namespace = var.namespace
    labels = {
      app = "notification-hub"
    }
  }

  spec {
    replicas = var.replicas

    selector {
      match_labels = {
        app = "notification-hub"
      }
    }

    template {
      metadata {
        labels = {
          app = "notification-hub"
        }
      }

      spec {
        container {
          name  = "notification-hub"
          image = var.image

          port {
            name           = "http"
            container_port = 8082
          }

          env {
            name  = "PORT"
            value = "8082"
          }

          env {
            name  = "NOTIFY_FROM"
            value = "noreply@example.com"
          }

          readiness_probe {
            http_get {
              path = "/api/health"
              port = "http"
            }
          }
        }
      }
    }
  }
}

resource "kubernetes_service_v1" "notification_hub" {
  metadata {
    name      = "notification-hub"
    namespace = var.namespace
  }

  spec {
    selector = {
      app = "notification-hub"
    }

    port {
      name        = "http"
      port        = 80
      target_port = "http"
    }
  }
}
