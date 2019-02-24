package com.chris.cheese.cheesemusic.controller.songorder;

import com.chris.cheese.cheesemusic.pojo.SongDO;
import com.chris.cheese.cheesemusic.pojo.SongOrderDO;
import com.chris.cheese.cheesemusic.pojo.songmodel.Song;
import com.chris.cheese.cheesemusic.service.SongOrderService;
import com.chris.cheese.cheesemusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songOrder")
public class SongOrderRestController {
    @Autowired
    private SongOrderService songOrderService;
    @Autowired
    private SongService songService;

    @PostMapping("/pickSong")
    public String pickSong(SongOrderDO songOrderDO) {
        Song song = songService.getSingleSong(songOrderDO.getSongId());
        SongDO songDO = new SongDO();
        songDO.setId(song.getId());
        songDO.setSongName(song.getName());
        songDO.setSongSinger(song.getSinger());
        songDO.setSongTime(song.getTime());
        songDO.setUrl(song.getUrl());
        songDO.setLrc(song.getLrc());
        songDO.setPic(song.getPic());
        songOrderService.doSave(songOrderDO, songDO);
        return "success";
    }
}
