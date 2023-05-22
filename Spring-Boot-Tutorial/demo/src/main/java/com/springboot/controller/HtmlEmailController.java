package com.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/email")
public class HtmlEmailController {

//    @Autowired
//    private JavaMailSender jms;
//
//    @Value("${spring.mail.username}")
//    private String from;
//
//    @Autowired
//    private TemplateEngine templateEngine;

    @RequestMapping("sendHtmlEmail")
    public String sendHtmlEmail() {
//        MimeMessage message = null;
//        try {
//            message = jms.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo("shengping@ustc.edu"); // 接收地址
//            helper.setSubject("一封HTML格式的邮件"); // 标题
//            // 带HTML格式的内容
//            StringBuffer sb = new StringBuffer("<p style='color:#6db33f'>使用Spring Boot发送HTML格式邮件。</p>");
//            helper.setText(sb.toString(), true);
//            jms.send(message);
            return "发送成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }

    @RequestMapping("sendTemplateEmail")
    public String sendTemplateEmail(String code) {
        MimeMessage message = null;
//        try {
//            message = jms.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo("shengping@ustc.edu"); // 接收地址
//            helper.setSubject("邮件摸板测试"); // 标题
//            // 处理邮件模板
//            Context context = new Context();
//            context.setVariable("code", code);
//            String template = templateEngine.process("emailTemplate", context);
//            helper.setText(template, true);
//            jms.send(message);
            return "发送成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }
}
