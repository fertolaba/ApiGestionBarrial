package com.example.demo.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.springframework.mail.*;
@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;
    public void sendEmail(String to, String subject, String text) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);

            emailSender.send(message);
        } catch (MessagingException e) {
            // Manejar la excepción adecuadamente, por ejemplo, logueándola o lanzándola
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo electrónico", e);
        }
    }

}
