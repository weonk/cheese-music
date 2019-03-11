package com.chris.cheese.cheesemusic.controller.songorder;

import com.chris.cheese.cheesemusic.service.SongOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongOrderController {

    @Autowired
    private SongOrderService songOrderService;

    @RequestMapping("/history/{userId}")
    public String history(@PathVariable(value = "userId") Long userId, Model model) {
        model.addAttribute("songQueryVoList", songOrderService.findByUserId(userId));
        return "history";
    }

    @RequestMapping("history/admin")
    public String history(Model model) {
        model.addAttribute("songQueryVoList", songOrderService.findByOld());
        return "admin-history";
    }
}
