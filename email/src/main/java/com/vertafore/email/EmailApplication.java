package com.vertafore.email;

import com.vertafore.email.model.EmailOption;
import com.vertafore.email.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class EmailApplication {
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        ConfigurableApplicationContext context = SpringApplication.run(EmailApplication.class, args);

        EmailService emailService = context.getBean(EmailService.class);

        emailService.sendMessage(EmailOption.MIME_MESSAGE_WITH_ATTACHMENTS);
    }
}
