package com.chris.cheese.cheesemusic.controller.user;

import com.chris.cheese.cheesemusic.pojo.UserDO;
import com.chris.cheese.cheesemusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public String signIn(UserDO userDO, HttpServletRequest request) {
        userDO = userService.signIn(userDO);
        if (userDO != null) {
            request.getSession().setAttribute("user", userDO);
            return "success";
        }
        return "fail";
    }

    @PostMapping("/signUp")
    public String signUp(UserDO userDO) {
        userService.signUp(userDO);
        return "success";
    }

    @PostMapping("/accountCheck")
    public boolean accountCheck(UserDO userDO) {
        if (userService.findByAccount(userDO) != null) {
            return false;
        }
        return true;
    }
}
