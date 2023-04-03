package com.example.webbanhangfinal.MVC.Service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.webbanhangfinal.auththenticate.Register.Email.EmailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;

    @Override
    public void Send(String to, String emailContent) {
       
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setFrom("hackkerds1@gmail.com");
            helper.setText(emailContent, true);
            helper.setSubject("active your account");
            helper.setTo(to);
            // mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new IllegalStateException("an error when sending email");
        }
        
    }

    
}
