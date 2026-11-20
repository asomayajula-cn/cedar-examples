package com.asomayajula.cedar.notify.domain;

public record EmailMessage(String to, String subject, String body) {

  public EmailMessage {
    if (to == null || !to.contains("@") || to.startsWith("@") || to.endsWith("@")) {
      throw new IllegalArgumentException("to must be an email address");
    }
    if (subject == null || subject.isBlank()) {
      throw new IllegalArgumentException("subject is required");
    }
    if (body == null || body.isBlank()) {
      throw new IllegalArgumentException("body is required");
    }
    to = to.strip();
    subject = subject.strip();
  }
}
