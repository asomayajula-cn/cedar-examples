package com.asomayajula.cedar.notify.infrastructure.config;

import com.asomayajula.cedar.notify.application.EmailSender;
import com.asomayajula.cedar.notify.application.SendEmail;
import com.asomayajula.cedar.notify.infrastructure.LoggingEmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifyConfig {

  @Bean
  EmailSender emailSender() {
    return new LoggingEmailSender();
  }

  @Bean
  SendEmail sendEmail(EmailSender emailSender) {
    return new SendEmail(emailSender);
  }
}
