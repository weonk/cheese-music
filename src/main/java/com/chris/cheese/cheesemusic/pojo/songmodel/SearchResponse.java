package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SearchResponse<T> {
    private String result;
    private String code;
    private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
