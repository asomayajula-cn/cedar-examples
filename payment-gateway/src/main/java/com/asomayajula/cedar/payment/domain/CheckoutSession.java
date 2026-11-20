package com.asomayajula.cedar.payment.domain;

public record CheckoutSession(String id, String customerId, Money amount, String status) {

  public CheckoutSession {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("id is required");
    }
    if (customerId == null || customerId.isBlank()) {
      throw new IllegalArgumentException("customerId is required");
    }
    if (amount == null) {
      throw new IllegalArgumentException("amount is required");
    }
    if (!"open".equals(status)) {
      throw new IllegalArgumentException("new sessions start open");
    }
  }
}
