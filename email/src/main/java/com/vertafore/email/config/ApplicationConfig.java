package com.vertafore.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class ApplicationConfig {

    @Value("${smtp.host}")
    String mailSenderHost;

    @Value("${smtp.port}")
    int mailSenderPort;

    @Value("${smtp.username}")
    String mailSenderUserName;

    @Value("${smtp.password}")
    String mailSenderPassword;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailSenderHost);
        mailSender.setPort(mailSenderPort);

        mailSender.setUsername(mailSenderUserName);
        mailSender.setPassword(mailSenderPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
