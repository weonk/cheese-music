package com.chris.cheese.cheesemusic.controller;

import com.chris.cheese.cheesemusic.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("send")
    public String send(String to,String userAccount,String leaveMessage) {
        try {
            mailService.sendHtmlMail(to, userAccount, leaveMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Send Ok";
    }
}
