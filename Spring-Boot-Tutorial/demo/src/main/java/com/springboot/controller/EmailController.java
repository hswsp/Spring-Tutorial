package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
@RequestMapping("/email")
public class EmailController {

//    @Autowired
//    private JavaMailSender jms;
//
//    @Value("${spring.mail.username}")
//    private String from;

    @RequestMapping("sendSimpleEmail")
    public String sendSimpleEmail() {
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(from);
//            message.setTo("shengping@ustc.edu"); // 接收地址
//            message.setSubject("一封简单的邮件"); // 标题
//            message.setText("使用Spring Boot发送简单邮件。"); // 内容
//            jms.send(message);
            return "发送成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }

    @RequestMapping("sendAttachmentsMail")
    public String sendAttachmentsMail() {
        MimeMessage message = null;
//        try {
//            message = jms.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo("shengping@ustc.edu"); // 接收地址
//            helper.setSubject("一封带附件的邮件"); // 标题
//            helper.setText("详情参见附件内容！"); // 内容
//            // 传入附件
//            FileSystemResource file = new FileSystemResource(new File("/Users/wu000376/Documents/安装手册.txt"));
//            helper.addAttachment("项目文档.docx", file);
//            jms.send(message);
            return "发送成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }

    @RequestMapping("sendInlineMail")
    public String sendInlineMail() {
        MimeMessage message = null;
//        try {
//            message = jms.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo("shengping@ustc.edu"); // 接收地址
//            helper.setSubject("一封带静态资源的邮件"); // 标题
//            helper.setText("<html><body>博客图：<img src='cid:img'/></body></html>", true); // 内容
//            // 传入附件
//            FileSystemResource file = new FileSystemResource(new File("/Users/wu000376/Pictures/WechatIMG1.png"));
//            helper.addInline("img", file);
//            jms.send(message);
            return "发送成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }

    }
}
