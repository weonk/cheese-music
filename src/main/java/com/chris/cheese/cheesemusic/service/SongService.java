package com.chris.cheese.cheesemusic.service;

import com.chris.cheese.cheesemusic.dao.SongDao;
import com.chris.cheese.cheesemusic.pojo.SongDO;
import com.chris.cheese.cheesemusic.pojo.songmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    @Autowired
    private RestTemplate restTemplate;

    public List<Song> getHotSingle() {
        SongListResponse songListResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/songList?key=579621905&id=3833853300", SongListResponse.class);
        return songListResponse.getData().getSongs().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
    }

    public List<SongSheet> getSongSheet(String categoryId) {
        SongSheetResponse songSheetResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/hotSongList?key=579621905&sortId=3&limit=19&categoryId=" + categoryId, SongSheetResponse.class);
        return songSheetResponse.getData();
    }

    public List<MV> getMV(String area, Integer offset) {
        MVResponse mvResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/hotMvList?key=579621905&limit=20&area=" + area + "&offset=" + offset, MVResponse.class);
        return mvResponse.getData();
    }

    public List getSearch(String type, String keyWord) {
        switch (type) {
            case "song":
                SongSearchResponse songSearchResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, SongSearchResponse.class);
                return songSearchResponse.getData().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
            case "list":
                SheetSearchResponse sheetDetailSearchResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, SheetSearchResponse.class);
                return sheetDetailSearchResponse.getData().stream().map(item -> {
                    SongSheet songSheet = new SongSheet();
                    songSheet.setId(item.getDissid());
                    songSheet.setName(item.getDissname());
                    songSheet.setCreator(item.getCreator().getName());
                    songSheet.setPic(item.getImgurl());
                    songSheet.setPlayCount(item.getListennum());
                    songSheet.setCreateTime(item.getCreateTime());
                    return songSheet;
                }).collect(Collectors.toList());
            case "mv":
                MVSearchResponse mvDetailSearchResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, MVSearchResponse.class);
                return mvDetailSearchResponse.getData().stream().map(item -> {
                    MV mv = new MV();
                    mv.setId(item.getV_id());
                    mv.setName(item.getMv_name());
                    mv.setSinger(item.getSinger_name());
                    mv.setPublictime(item.getPublish_date());
                    mv.setPic(item.getMv_pic_url());
                    mv.setUrl("");
                    mv.setPlayCount(item.getPlay_count());
                    return mv;
                }).collect(Collectors.toList());
            case "album":
                AlbumSearchResponse albumSearchResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, AlbumSearchResponse.class);
                return albumSearchResponse.getData();
            default:
                return null;
        }
    }

    public SongListData getSheet(String sheetId) {
        SongListResponse songListResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/songList?key=579621905&id=" + sheetId, SongListResponse.class);
        songListResponse.getData().getSongs().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
        return songListResponse.getData();
    }

    public AlbumData getAlbum(String albumId) {
        AlbumResponse albumResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/album?key=579621905&id=" + albumId, AlbumResponse.class);
        albumResponse.getData().getSongs().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
        return albumResponse.getData();
    }

    public Song getSingleSong(String singleId) {
        SongResponse songResponse = restTemplate.getForObject("https://api.bzqll.com/music/tencent/song?key=579621905&id=" + singleId, SongResponse.class);
        return songResponse.getData();
    }

    public static Song songTimeFormat(Song song) {
        StringBuilder stringBuilder = new StringBuilder();
        int songTime = Integer.parseInt(song.getTime());
        int s = songTime % 60;
        int m = (songTime - s) / 60;
        if (m >= 0 && m < 10) {
            stringBuilder.append("0").append(m).append(":");
        } else {
            stringBuilder.append(m).append(":");
        }
        if (s >= 0 && s < 10) {
            stringBuilder.append("0").append(s);
        } else {
            stringBuilder.append(s);
        }
        song.setTime(stringBuilder.toString());
        return song;
    }
}
