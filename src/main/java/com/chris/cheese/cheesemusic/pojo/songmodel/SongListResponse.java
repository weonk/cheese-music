package com.chris.cheese.cheesemusic.pojo.songmodel;

public class SongListResponse {
    private String result;
    private Integer code;
    private SongListData data;

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

    public SongListData getData() {
        return data;
    }

    public void setData(SongListData data) {
        this.data = data;
    }
}
