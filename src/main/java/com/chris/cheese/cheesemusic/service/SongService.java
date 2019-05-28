package com.chris.cheese.cheesemusic.service;

import com.chris.cheese.cheesemusic.pojo.songmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${cheese.music.api}")
    private String apiUri;

    public List<Song> getHotSingle() {
        SongListResponse songListResponse = restTemplate.getForObject(apiUri + "music/netease/songList?key=579621905&id=3778678", SongListResponse.class);
        return songListResponse.getData().getSongs().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
    }

    public List<SongSheet> getSongSheet(Integer offset) {
        SongSheetResponse songSheetResponse = restTemplate.getForObject(apiUri + "music/netease/hotSongList?key=579621905&limit=20&offset=" + offset, SongSheetResponse.class);
        return songSheetResponse.getData();
    }

    public List<MV> getMV(String area, Integer offset) {
        MVResponse mvResponse = restTemplate.getForObject( apiUri + "music/tencent/hotMvList?key=579621905&limit=20&area=" + area + "&offset=" + offset, MVResponse.class);
        return mvResponse.getData();
    }

    public List getSearch(String type, String keyWord) {
        switch (type) {
            case "song":
                SongSearchResponse songSearchResponse = restTemplate.getForObject(apiUri + "music/netease/search?key=579621905&s=" + keyWord + "&type=" + type, SongSearchResponse.class);
                return songSearchResponse.getData().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
            case "list":
                SheetSearchResponse sheetDetailSearchResponse = restTemplate.getForObject( apiUri +"music/netease/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, SheetSearchResponse.class);
                return sheetDetailSearchResponse.getData().getPlaylists().stream().map(item -> {
                    SongSheet songSheet = new SongSheet();
                    songSheet.setId(item.getId());
                    songSheet.setTitle(item.getName());
                    songSheet.setCreator(item.getCreator().getNickname());
                    songSheet.setCoverImgUrl(item.getCoverImgUrl());
                    songSheet.setPlayCount(item.getPlayCount());
                    songSheet.setDescription(item.getDescription());
                    songSheet.setSongNum(item.getTrackCount());
                    return songSheet;
                }).collect(Collectors.toList());
            case "mv":
                MVSearchResponse mvDetailSearchResponse = restTemplate.getForObject(apiUri + "music/tencent/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, MVSearchResponse.class);
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
                AlbumSearchResponse albumSearchResponse = restTemplate.getForObject(apiUri + "music/netease/search?key=579621905&limit=48&s=" + keyWord + "&type=" + type, AlbumSearchResponse.class);
                return albumSearchResponse.getData();
            default:
                return null;
        }
    }

    public SongListData getSheet(String sheetId) {
        SongListResponse songListResponse = restTemplate.getForObject(apiUri + "music/netease/songList?key=579621905&id=" + sheetId, SongListResponse.class);
        songListResponse.getData().getSongs().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
        return songListResponse.getData();
    }

    public AlbumData getAlbum(String albumId) {
        AlbumResponse albumResponse = restTemplate.getForObject(apiUri + "music/tencent/album?key=579621905&id=" + albumId, AlbumResponse.class);
        albumResponse.getData().getSongs().stream().map(SongService::songTimeFormat).collect(Collectors.toList());
        return albumResponse.getData();
    }

    public Song getSingleSong(String singleId) {
        SongResponse songResponse = restTemplate.getForObject(apiUri + "music/netease/song?key=579621905&id=" + singleId, SongResponse.class);
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
