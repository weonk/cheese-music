package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class AlbumSearchResponse {
    private String result;
    private String code;

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

    public List<AlbumDetail> getData() {
        return data;
    }

    public void setData(List<AlbumDetail> data) {
        this.data = data;
    }

    private List<AlbumDetail> data;
}
