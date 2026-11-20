package com.asomayajula.cedar.payment.application;

import com.asomayajula.cedar.payment.domain.CheckoutSession;
import com.asomayajula.cedar.payment.domain.Money;
import java.util.UUID;

public final class CreateCheckoutSession {

  private final CheckoutSessionRepository repository;

  public CreateCheckoutSession(CheckoutSessionRepository repository) {
    this.repository = repository;
  }

  public CheckoutSession create(String customerId, Money amount) {
    if (customerId == null || customerId.isBlank()) {
      throw new IllegalArgumentException("customerId is required");
    }
    CheckoutSession session = new CheckoutSession(
        UUID.randomUUID().toString(),
        customerId.strip(),
        amount,
        "open"
    );
    return repository.save(session);
  }
}
