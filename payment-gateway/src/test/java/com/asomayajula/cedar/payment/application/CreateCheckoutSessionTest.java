package com.asomayajula.cedar.payment.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.asomayajula.cedar.payment.domain.CheckoutSession;
import com.asomayajula.cedar.payment.domain.Money;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.Test;

class CreateCheckoutSessionTest {

  @Test
  void storesOpenSession() {
    FakeRepository repository = new FakeRepository();
    CreateCheckoutSession useCase = new CreateCheckoutSession(repository);

    CheckoutSession session = useCase.create("cust_1", new Money(2500, "usd"));

    assertEquals("open", session.status());
    assertEquals("cust_1", session.customerId());
    assertEquals("USD", session.amount().currency());
    assertEquals(session, repository.saved.get(session.id()));
  }

  @Test
  void rejectsBlankCustomer() {
    CreateCheckoutSession useCase = new CreateCheckoutSession(new FakeRepository());

    assertThrows(IllegalArgumentException.class, () -> useCase.create("  ", new Money(100, "usd")));
  }

  private static final class FakeRepository implements CheckoutSessionRepository {

    private final ConcurrentMap<String, CheckoutSession> saved = new ConcurrentHashMap<>();

    @Override
    public CheckoutSession save(CheckoutSession session) {
      saved.put(session.id(), session);
      return session;
    }
  }
}
