package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SongListData {
    private String songListId;
    private String songListName;
    private String songListDescription;
    private String songListUserId;
    private String songListCount;
    private String songListPic;
    private String songListPlayCount;
    private List<Song> songs;

    public String getSongListId() {
        return songListId;
    }

    public void setSongListId(String songListId) {
        this.songListId = songListId;
    }

    public String getSongListName() {
        return songListName;
    }

    public void setSongListName(String songListName) {
        this.songListName = songListName;
    }

    public String getSongListDescription() {
        return songListDescription;
    }

    public void setSongListDescription(String songListDescription) {
        this.songListDescription = songListDescription;
    }

    public String getSongListUserId() {
        return songListUserId;
    }

    public void setSongListUserId(String songListUserId) {
        this.songListUserId = songListUserId;
    }

    public String getSongListCount() {
        return songListCount;
    }

    public void setSongListCount(String songListCount) {
        this.songListCount = songListCount;
    }

    public String getSongListPic() {
        return songListPic;
    }

    public void setSongListPic(String songListPic) {
        this.songListPic = songListPic;
    }

    public String getSongListPlayCount() {
        return songListPlayCount;
    }

    public void setSongListPlayCount(String songListPlayCount) {
        this.songListPlayCount = songListPlayCount;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
