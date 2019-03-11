package com.chris.cheese.cheesemusic.controller.song;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("song")
public class SongRestController {

    private String songStatusMessage;

    @PostMapping("/sendStatus")
    public String sendSongStatus(String message) {
        if (message != null && message.length() > 0) {
            this.songStatusMessage = message;
            return "success";
        }
        return "fail";
    }

    @GetMapping("/getStatus")
    public String getSongStatus() {
        return this.songStatusMessage;
    }

}
