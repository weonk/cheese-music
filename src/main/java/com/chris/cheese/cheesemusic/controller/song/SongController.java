package com.chris.cheese.cheesemusic.controller.song;

import com.chris.cheese.cheesemusic.pojo.SongOrderDetail;
import com.chris.cheese.cheesemusic.pojo.SongQueryVo;
import com.chris.cheese.cheesemusic.service.SongOrderService;
import com.chris.cheese.cheesemusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private SongOrderService songOrderService;

    @RequestMapping("/hotSingle")
    public String hotSingle(Model model) {
        model.addAttribute("songList", songService.getHotSingle());
        return "hot-single";
    }

    @RequestMapping("/hotSheet/{offset}")
    public String hotSheet(@PathVariable(name = "offset") Integer offset, Model model) {
        model.addAttribute("sheetList", songService.getSongSheet(offset));
        model.addAttribute("offset", offset);
        return "hot-sheet";
    }

    @RequestMapping("/hotMV/{area}/{offset}")
    public String hotMV(@PathVariable(name = "area") String area, @PathVariable(name = "offset") Integer offset, Model model) {
        model.addAttribute("mvList", songService.getMV(area, offset));
        model.addAttribute("area", area);
        model.addAttribute("offset", offset);
        return "hot-mv";
    }

    @RequestMapping("/doSearch/{type}/{keyWord}")
    public String doSearch(@PathVariable(name = "type") String type, @PathVariable(name = "keyWord") String keyWord, Model model) {
        model.addAttribute("resultList", songService.getSearch(type, keyWord)).addAttribute("type", type).addAttribute("keyWord", keyWord);
        model.addAttribute("type", type);
        model.addAttribute("keyWord", keyWord);
        return "search-result";
    }

    @RequestMapping("/sheetSongs/{sheetId}")
    public String sheetSongs(@PathVariable(name = "sheetId") String sheetId, Model model) {
        model.addAttribute("sheet", songService.getSheet(sheetId));
        return "sheet-detail";
    }

    @RequestMapping("/albumSongs/{albumId}")
    public String albumSongs(@PathVariable(name = "albumId") String albumId, Model model) {
        model.addAttribute("album", songService.getAlbum(albumId));
        return "album-detail";
    }

    @RequestMapping("/songTable/{userId}")
    public String songTable(Model model, @PathVariable(name = "userId") Long userId) {
        List<SongQueryVo> songQueryVoList = songOrderService.findByNew();
        model.addAttribute("songQueryVoList", songQueryVoList);
        model.addAttribute("songOrderDetailList", packageSongQuery(songQueryVoList));
        return "song-table";
    }

    @RequestMapping("songTable/admin")
    public String songTable(Model model) {
        List<SongQueryVo> songQueryVoList = songOrderService.findByNew();
        model.addAttribute("songQueryVoList", songQueryVoList);
        model.addAttribute("songOrderDetailList", packageSongQuery(songQueryVoList));
        return "admin-song-table";
    }

    private List<SongOrderDetail> packageSongQuery(List<SongQueryVo> songQueryVoList) {
        return songQueryVoList.stream().map(item -> {
            SongOrderDetail songOrderDetail = new SongOrderDetail();
            songOrderDetail.setSongId(item.getSongDO().getId());
            songOrderDetail.setSongName(item.getSongDO().getSongName());
            songOrderDetail.setSongSinger(item.getSongDO().getSongSinger());
            songOrderDetail.setSongTime(item.getSongDO().getSongTime());
            songOrderDetail.setUrl(item.getSongDO().getUrl());
            songOrderDetail.setPic(item.getSongDO().getPic());
            songOrderDetail.setLrc(item.getSongDO().getLrc());
            songOrderDetail.setSongOrderId(String.valueOf(item.getSongOrderDO().getId()));
            songOrderDetail.setToName(item.getSongOrderDO().getToName());
            songOrderDetail.setLeaveMessage(item.getSongOrderDO().getLeaveMessage());
            songOrderDetail.setUserId(item.getUserDO().getId());
            songOrderDetail.setAccount(item.getUserDO().getAccount());
            return songOrderDetail;
        }).collect(Collectors.toList());
    }
}
