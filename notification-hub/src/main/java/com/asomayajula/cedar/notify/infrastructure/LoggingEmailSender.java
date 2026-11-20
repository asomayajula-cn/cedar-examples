package com.asomayajula.cedar.notify.infrastructure;

import com.asomayajula.cedar.notify.application.EmailSender;
import com.asomayajula.cedar.notify.domain.EmailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggingEmailSender implements EmailSender {

  private static final Logger log = LoggerFactory.getLogger(LoggingEmailSender.class);

  @Override
  public void send(EmailMessage message) {
    log.info("email accepted to={} subject={}", message.to(), message.subject());
  }
}
