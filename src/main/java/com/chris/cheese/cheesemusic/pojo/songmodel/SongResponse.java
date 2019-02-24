package com.chris.cheese.cheesemusic.pojo.songmodel;

public class SongResponse {
    private String result;
    private String code;
    private Song data;

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

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }
}
