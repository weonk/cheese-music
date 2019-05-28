package com.chris.cheese.cheesemusic.pojo.songmodel;


public class SheetSearchResponse {
    private String result;
    private String code;
    private PlayLists data;

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

    public PlayLists getData() {
        return data;
    }

    public void setData(PlayLists data) {
        this.data = data;
    }
}
