package com.asomayajula.cedar.payment.api;

import com.asomayajula.cedar.payment.api.dto.CheckoutSessionResponse;
import com.asomayajula.cedar.payment.api.dto.CreateCheckoutSessionRequest;
import com.asomayajula.cedar.payment.application.CreateCheckoutSession;
import com.asomayajula.cedar.payment.domain.CheckoutSession;
import com.asomayajula.cedar.payment.domain.Money;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout-sessions")
public class CheckoutSessionController {

  private final CreateCheckoutSession createCheckoutSession;

  public CheckoutSessionController(CreateCheckoutSession createCheckoutSession) {
    this.createCheckoutSession = createCheckoutSession;
  }

  @PostMapping
  public ResponseEntity<CheckoutSessionResponse> create(
      @Valid @RequestBody CreateCheckoutSessionRequest request
  ) {
    CheckoutSession session = createCheckoutSession.create(
        request.customerId(),
        new Money(request.amountCents(), request.currency())
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(CheckoutSessionResponse.from(session));
  }
}
