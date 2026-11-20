resource "kubernetes_deployment_v1" "payment_gateway" {
  metadata {
    name      = "payment-gateway"
    namespace = var.namespace
    labels = {
      app = "payment-gateway"
    }
  }

  spec {
    replicas = var.replicas

    selector {
      match_labels = {
        app = "payment-gateway"
      }
    }

    template {
      metadata {
        labels = {
          app = "payment-gateway"
        }
      }

      spec {
        container {
          name  = "payment-gateway"
          image = var.image

          port {
            name           = "http"
            container_port = 8081
          }

          env {
            name  = "PORT"
            value = "8081"
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

resource "kubernetes_service_v1" "payment_gateway" {
  metadata {
    name      = "payment-gateway"
    namespace = var.namespace
  }

  spec {
    selector = {
      app = "payment-gateway"
    }

    port {
      name        = "http"
      port        = 80
      target_port = "http"
    }
  }
}
