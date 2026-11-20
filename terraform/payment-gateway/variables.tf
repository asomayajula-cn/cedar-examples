variable "namespace" {
  description = "Kubernetes namespace for the payment gateway"
  type        = string
  default     = "cedar-examples"
}

variable "image" {
  description = "payment-gateway container image"
  type        = string
  default     = "ghcr.io/asomayajula-cn/payment-gateway:main"
}

variable "replicas" {
  description = "How many payment-gateway pods to run"
  type        = number
  default     = 2
}
