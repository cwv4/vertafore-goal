package com.vertafore.email.service;

import com.vertafore.email.model.EmailOption;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class EmailService {

    @Value("${smtp.sender.email}")
    String senderEmail;

    @Value("${sender.name}")
    String senderName;

    @Value("${smtp.recipient}")
    String recipientEmail;

    private final JavaMailSender emailSender;

    private static final String BODY = """
            This is a MimeMessage.<br><br>
            
            Hello, this is the body of the email. Cool!<br><br>
            
            Yay!<br><br>
            
            Yours truly
            """;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMessage(EmailOption option) throws MessagingException, UnsupportedEncodingException {
        switch (option) {
            case SIMPLE_MESSAGE -> sendSimpleMessage();
            case MIME_MESSAGE -> sendMimeMessage();
            case MIME_MESSAGE_WITH_ATTACHMENTS -> sendMimeMessageWithAttachments();
        }
    }

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(recipientEmail);
        message.setSubject("This is a test");
        message.setText(BODY);
        emailSender.send(message);
    }

    public void sendMimeMessage() throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        mimeMessage.setContent(BODY, "text/html");

        mimeMessage.setRecipient(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)[0]);
        mimeMessage.setSubject("This is a mime test");
        InternetAddress sender = new InternetAddress(senderEmail, senderName);
        mimeMessage.setFrom(sender);
        emailSender.send(mimeMessage);
    }

    public void sendMimeMessageWithAttachments() throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

        helper.setText(BODY, true);
        mimeMessage.setHeader("MessageStream", "outbound");

        helper.setTo(recipientEmail);
        helper.setSubject("This is a mime test");
        InternetAddress sender = new InternetAddress(senderEmail, senderName);
        helper.setFrom(sender);

        List<File> files = getFiles();
        int i = 1;
        for (File file : files) {
            helper.addAttachment("file" + i + ".txt", file);
            i++;
        }

        emailSender.send(mimeMessage);
    }

    private List<File> getFiles() {
        File file1 = new File("email/src/main/resources/file1.txt");
        File file2 = new File("email/src/main/resources/file2.txt");
        return List.of(file1, file2);
    }
}
