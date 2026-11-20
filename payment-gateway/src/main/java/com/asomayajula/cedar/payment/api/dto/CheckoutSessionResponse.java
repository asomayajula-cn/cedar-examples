package com.asomayajula.cedar.payment.api.dto;

import com.asomayajula.cedar.payment.domain.CheckoutSession;

public record CheckoutSessionResponse(
    String id,
    String customerId,
    String status,
    long amountCents,
    String currency
) {

  public static CheckoutSessionResponse from(CheckoutSession session) {
    return new CheckoutSessionResponse(
        session.id(),
        session.customerId(),
        session.status(),
        session.amount().amountCents(),
        session.amount().currency()
    );
  }
}
