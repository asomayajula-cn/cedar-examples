package com.asomayajula.cedar.payment.application;

import com.asomayajula.cedar.payment.domain.CheckoutSession;

public interface CheckoutSessionRepository {

  CheckoutSession save(CheckoutSession session);
}
