package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SongListData {
    private String id;
    private String title;
    private String desc;
    private String author;
    private String songnum;
    private String logo;
    private List<Song> songs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSongnum() {
        return songnum;
    }

    public void setSongnum(String songnum) {
        this.songnum = songnum;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
