package com.chris.cheese.cheesemusic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送文本邮件
     *
     * @param to 接收人
     * @param subject 主题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
    }

    /**
     * 发送HTML邮件
     *
     * @param to 接收人
     * @param subject 主题
     * @param content 邮件内容
     */
    public void sendHtmlMail(String to,String userAccount,String leaveMessage) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        String subject = userAccount + "为你点了一首歌，快去看看吧";
        String content = userAccount + "为你点了一首歌</br>";
        content += "</hr>";
        content += "留言： " + leaveMessage + "</br>";
        content += "<a href=\"http://localhost:8080\">点击查看</a>";
        helper.setFrom(new InternetAddress(from,"芝士音乐","UTF-8"));
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(mimeMessage);
    }



    
}
