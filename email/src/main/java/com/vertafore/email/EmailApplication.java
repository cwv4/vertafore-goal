package com.vertafore.email;

import com.vertafore.email.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmailApplication {
    public static void main(String[] args) throws MessagingException {
        ConfigurableApplicationContext context = SpringApplication.run(EmailApplication.class, args);

        EmailService emailService = context.getBean(EmailService.class);

        emailService.sendMimeMessageWithAttachments();
    }
}
