package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SongSearchResponse {
    private String result;
    private String code;
    private List<Song> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Song> getData() {
        return data;
    }

    public void setData(List<Song> data) {
        this.data = data;
    }
}
