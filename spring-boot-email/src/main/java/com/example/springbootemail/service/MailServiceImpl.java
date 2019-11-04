package com.example.springbootemail.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("邮箱已经发送");
        } catch (MailException e) {
            e.printStackTrace();
            logger.error("邮箱发送失败");
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mailSender.send(message);
            logger.info("邮箱已经发送Html");
        } catch (MailException e) {
            e.printStackTrace();
            logger.error("邮箱发送Html失败");
        }

    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource resource = new FileSystemResource(new File(filePath));
            String filename = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
            helper.addAttachment(filename, resource);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {

            mailSender.send(message);
            logger.info("邮箱已经发送Html");
        } catch (MailException e) {
            e.printStackTrace();
            logger.error("邮箱发送Html失败");
        }
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource resource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, resource);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {

            mailSender.send(message);
            logger.info("邮箱已经发送Html");
        } catch (MailException e) {
            e.printStackTrace();
            logger.error("邮箱发送Html失败");
        }
    }
}
