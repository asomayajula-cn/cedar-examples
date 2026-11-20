package com.asomayajula.cedar.notify.api.dto;

import com.asomayajula.cedar.notify.domain.EmailMessage;

public record SendEmailResponse(String to, String subject, String status) {

  public static SendEmailResponse accepted(EmailMessage message) {
    return new SendEmailResponse(message.to(), message.subject(), "accepted");
  }
}
