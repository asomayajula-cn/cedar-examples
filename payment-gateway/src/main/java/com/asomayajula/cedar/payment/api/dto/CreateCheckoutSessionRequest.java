package com.asomayajula.cedar.payment.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record CreateCheckoutSessionRequest(
    @NotBlank String customerId,
    @Positive long amountCents,
    @NotBlank @Pattern(regexp = "[A-Za-z]{3}") String currency
) {}
