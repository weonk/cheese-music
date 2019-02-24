package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class AlbumDetail {
    private String albumID;
    private String albumMID;
    private String albumName;
    private String albumName_hilight;
    private String albumPic;
    private String catch_song;
    private String docid;
    private String publicTime;
    private String singerID;
    private String singerMID;
    private String singerName;
    private String singerName_hilight;
    private List<Singer> singer_list;
    private String song_count;
    private String type;

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getAlbumMID() {
        return albumMID;
    }

    public void setAlbumMID(String albumMID) {
        this.albumMID = albumMID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName_hilight() {
        return albumName_hilight;
    }

    public void setAlbumName_hilight(String albumName_hilight) {
        this.albumName_hilight = albumName_hilight;
    }

    public String getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(String albumPic) {
        this.albumPic = albumPic;
    }

    public String getCatch_song() {
        return catch_song;
    }

    public void setCatch_song(String catch_song) {
        this.catch_song = catch_song;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }

    public String getSingerID() {
        return singerID;
    }

    public void setSingerID(String singerID) {
        this.singerID = singerID;
    }

    public String getSingerMID() {
        return singerMID;
    }

    public void setSingerMID(String singerMID) {
        this.singerMID = singerMID;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerName_hilight() {
        return singerName_hilight;
    }

    public void setSingerName_hilight(String singerName_hilight) {
        this.singerName_hilight = singerName_hilight;
    }

    public List<Singer> getSinger_list() {
        return singer_list;
    }

    public void setSinger_list(List<Singer> singer_list) {
        this.singer_list = singer_list;
    }

    public String getSong_count() {
        return song_count;
    }

    public void setSong_count(String song_count) {
        this.song_count = song_count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
