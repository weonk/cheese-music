package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SongSheetResponse {
    private String result;
    private Integer code;
    private List<SongSheet> data;

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

    public List<SongSheet> getData() {
        return data;
    }

    public void setData(List<SongSheet> data) {
        this.data = data;
    }
}
