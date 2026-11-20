package com.asomayajula.cedar.payment.infrastructure.config;

import com.asomayajula.cedar.payment.application.CheckoutSessionRepository;
import com.asomayajula.cedar.payment.application.CreateCheckoutSession;
import com.asomayajula.cedar.payment.infrastructure.InMemoryCheckoutSessionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

  @Bean
  CheckoutSessionRepository checkoutSessionRepository() {
    return new InMemoryCheckoutSessionRepository();
  }

  @Bean
  CreateCheckoutSession createCheckoutSession(CheckoutSessionRepository repository) {
    return new CreateCheckoutSession(repository);
  }
}
