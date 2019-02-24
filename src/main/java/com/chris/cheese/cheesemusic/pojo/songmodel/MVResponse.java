package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class MVResponse {
    private String result;
    private String code;
    private List<MV> data;

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

    public List<MV> getData() {
        return data;
    }

    public void setData(List<MV> data) {
        this.data = data;
    }
}
