package com.chris.cheese.cheesemusic.pojo.songmodel;

import com.chris.cheese.cheesemusic.pojo.SongDO;

public class Song {
    private String id;
    private String name;
    private String singer;
    private String url;
    private String pic;
    private String lrc;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SongDO toSongDO() {
        SongDO songDO = new SongDO();
        songDO.setId(this.id);
        songDO.setSongName(this.name);
        songDO.setSongSinger(this.singer);
        songDO.setUrl(this.url);
        songDO.setPic(this.pic);
        songDO.setLrc(this.lrc);
        songDO.setSongTime(this.time);
        return songDO;
    }
}
