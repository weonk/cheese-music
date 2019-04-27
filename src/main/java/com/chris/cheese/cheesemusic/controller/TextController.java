package com.chris.cheese.cheesemusic.controller;

import com.chris.cheese.cheesemusic.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class TextController {
    @Autowired
    private MailService mailService;

    @PostMapping("send")
    public String send(String to,String subject,String content) {
        mailService.sendSimpleMail(to, subject, content);
        return "Send Ok";
    }
}
