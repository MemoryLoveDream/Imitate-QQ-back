package com.example.easychat.service.impl;

import jakarta.annotation.Nullable;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2274399174@qq.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendHtmlMail(String sendTo, String subject, String text, @Nullable List<File> files) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("2274399174@qq.com");
            helper.setTo(sendTo);
            helper.setSubject(subject);
            helper.setText(text, true);
            if (files != null) {
                for (File file : files) {
                    helper.addAttachment(file.getName(), new FileSystemResource(file));
                }
            }
            javaMailSender.send(message);
        } catch (MessagingException e) {
            log.error("邮件发送出错：{}", e.getMessage());
        }
    }

}
