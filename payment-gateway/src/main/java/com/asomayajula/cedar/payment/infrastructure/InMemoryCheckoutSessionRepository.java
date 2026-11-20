package com.asomayajula.cedar.payment.infrastructure;

import com.asomayajula.cedar.payment.application.CheckoutSessionRepository;
import com.asomayajula.cedar.payment.domain.CheckoutSession;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class InMemoryCheckoutSessionRepository implements CheckoutSessionRepository {

  private final ConcurrentMap<String, CheckoutSession> sessions = new ConcurrentHashMap<>();

  @Override
  public CheckoutSession save(CheckoutSession session) {
    sessions.put(session.id(), session);
    return session;
  }
}
