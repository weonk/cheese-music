package com.chris.cheese.cheesemusic.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cheese_song")
public class SongDO {
    @Id
    private String id;
    @Column
    private String songName;
    @Column
    private String songSinger;
    @Column
    private String songTime;
    @Column
    private String url;
    @Column
    private String pic;
    @Column
    private String lrc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongSinger() {
        return songSinger;
    }

    public void setSongSinger(String songSinger) {
        this.songSinger = songSinger;
    }

    public String getSongTime() {
        return songTime;
    }

    public void setSongTime(String songTime) {
        this.songTime = songTime;
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
}
