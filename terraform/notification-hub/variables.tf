variable "namespace" {
  description = "Kubernetes namespace for the notification hub"
  type        = string
  default     = "cedar-examples"
}

variable "image" {
  description = "notification-hub container image"
  type        = string
  default     = "ghcr.io/asomayajula-cn/notification-hub:main"
}

variable "replicas" {
  description = "How many notification-hub pods to run"
  type        = number
  default     = 2
}
