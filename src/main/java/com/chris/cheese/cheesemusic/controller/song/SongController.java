package com.chris.cheese.cheesemusic.controller.song;

import com.chris.cheese.cheesemusic.service.SongOrderService;
import com.chris.cheese.cheesemusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/hotSheet/{categoryId}")
    public String hotSheet(@PathVariable(name = "categoryId") String categoryId, Model model) {
        model.addAttribute("sheetList", songService.getSongSheet(categoryId));
        model.addAttribute("categoryId", categoryId);
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

    @RequestMapping("/songTable")
    public String songTable(Model model) {
        model.addAttribute("songQueryVoList", songOrderService.findByNew());
        return "song-table";
    }
}
