package com.asomayajula.cedar.notify.api;

import com.asomayajula.cedar.notify.api.dto.SendEmailRequest;
import com.asomayajula.cedar.notify.api.dto.SendEmailResponse;
import com.asomayajula.cedar.notify.application.SendEmail;
import com.asomayajula.cedar.notify.domain.EmailMessage;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

  private final SendEmail sendEmail;

  public EmailController(SendEmail sendEmail) {
    this.sendEmail = sendEmail;
  }

  @PostMapping
  public ResponseEntity<SendEmailResponse> send(@Valid @RequestBody SendEmailRequest request) {
    EmailMessage message = sendEmail.send(request.to(), request.subject(), request.body());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(SendEmailResponse.accepted(message));
  }
}
