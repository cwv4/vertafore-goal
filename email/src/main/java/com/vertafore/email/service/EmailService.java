/*
 *  Copyright 2025 Vertafore, Inc.   All rights reserved.
 *
 *  Disclaimers:
 *   This software is provided "as is," without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and non-infringement.  This source code
 *   should not be relied upon as the sole basis for solving a problem whose
 *   incorrect solution could result in injury to person or property. In no
 *   event shall the author or contributors be held liable for any damages
 *   arising in any way from the use of this software. The entire risk as to the
 *   results and performance of this source code is assumed by the user.
 *
 *   Permission is granted to use this software for internal use only, subject
 *   to the following restrictions:
 *     1.  This source code MUST retain the above copyright notice, disclaimer,
 *         and this list of conditions.
 *     2.  This source code may be used ONLY within the scope of the original
 *         agreement under which this source code was provided and may not be
 *         distributed to any third party without the express written consent of
 *         Vertafore, Inc.
 *     3.  This source code along with all obligations and rights under the
 *         original License Agreement may not be assigned to any third party
 *         without the expressed written consent of Vertafore, Inc., except that
 *         assignment may be made to a  successor to the business or
 *         substantially all of its assets. All parties bind their successors,
 *         executors, administrators, and assignees to all covenants of this
 *         Agreement.
 *
 *   All advertising materials mentioning features or use of this software must
 *   display the following acknowledgment:
 *
 *     Trademark Disclaimer:
 *     All patent, copyright, trademark and other intellectual property rights
 *     included in the source code are owned exclusively by Vertafore, Inc.
 */

package com.vertafore.email.service;

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
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class EmailService {

    @Value("${smtp.sender.email}")
    String mailSender;

    @Value("${smtp.recipient}")
    String mailRecipient;

    private final JavaMailSender emailSender;

    private static final String BODY = """
            This is a MimeMessage.<br><br>
            
            Hello, this is the body of the email. Cool!<br><br>
            
            Yay!<br><br>
            
            Your truly
            """;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender);
        message.setTo(mailRecipient);
        message.setSubject("This is a test");
        message.setText(BODY);
        emailSender.send(message);
    }

    public void sendMimeMessage() throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        mimeMessage.setContent(BODY, "text/html");

        mimeMessage.setRecipient(Message.RecipientType.TO, InternetAddress.parse(mailRecipient)[0]);
        mimeMessage.setSubject("This is a mime test");
        mimeMessage.setFrom(mailSender);
        emailSender.send(mimeMessage);
    }

    public void sendMimeMessageWithAttachments() throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

        helper.setText(BODY, true);
        mimeMessage.setHeader("MessageStream", "outbound");

        helper.setTo(mailRecipient);
        helper.setSubject("This is a mime test");
        helper.setFrom(mailSender);

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
