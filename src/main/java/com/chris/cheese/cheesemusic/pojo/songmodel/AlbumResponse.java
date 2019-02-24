package com.chris.cheese.cheesemusic.pojo.songmodel;

public class AlbumResponse {
    private String result;
    private Integer code;
    private AlbumData data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public AlbumData getData() {
        return data;
    }

    public void setData(AlbumData data) {
        this.data = data;
    }
}
