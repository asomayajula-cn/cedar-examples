package com.asomayajula.cedar.payment.domain;

import java.util.Locale;

public record Money(long amountCents, String currency) {

  public Money {
    if (amountCents <= 0) {
      throw new IllegalArgumentException("amountCents must be positive");
    }
    if (currency == null || !currency.matches("[A-Za-z]{3}")) {
      throw new IllegalArgumentException("currency must be a 3-letter code");
    }
    currency = currency.toUpperCase(Locale.ROOT);
  }
}
