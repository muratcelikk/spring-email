package com.cal.springemail;

import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
public class EmailSenderService {

    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String body,
                          String subject) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("muratcelik11@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Sent successfully...");
    }

    public void sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String pathToAttachment) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("muratcelik11@gmail.com");
        helper.setTo(toEmail);
        helper.setText(body);
        helper.setSubject(subject);

        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment(file.getFilename(), file);

        mailSender.send(message);
        System.out.println("Mail send..");
    }
}
