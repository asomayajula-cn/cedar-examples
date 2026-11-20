package com.asomayajula.cedar.notify.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.asomayajula.cedar.notify.domain.EmailMessage;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SendEmailTest {

  @Test
  void handsMessageToSender() {
    FakeSender sender = new FakeSender();
    SendEmail useCase = new SendEmail(sender);

    EmailMessage message = useCase.send("ada@example.com", "Welcome", "Hello");

    assertEquals("ada@example.com", message.to());
    assertEquals(List.of(message), sender.sent);
  }

  @Test
  void rejectsMissingSubject() {
    SendEmail useCase = new SendEmail(new FakeSender());

    assertThrows(IllegalArgumentException.class, () -> useCase.send("ada@example.com", " ", "Hello"));
  }

  private static final class FakeSender implements EmailSender {

    private final List<EmailMessage> sent = new ArrayList<>();

    @Override
    public void send(EmailMessage message) {
      sent.add(message);
    }
  }
}
