package com.asomayajula.cedar.notify.application;

import com.asomayajula.cedar.notify.domain.EmailMessage;

public interface EmailSender {

  void send(EmailMessage message);
}
