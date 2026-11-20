package com.asomayajula.cedar.notify.application;

import com.asomayajula.cedar.notify.domain.EmailMessage;

public final class SendEmail {

  private final EmailSender sender;

  public SendEmail(EmailSender sender) {
    this.sender = sender;
  }

  public EmailMessage send(String to, String subject, String body) {
    EmailMessage message = new EmailMessage(to, subject, body);
    sender.send(message);
    return message;
  }
}
