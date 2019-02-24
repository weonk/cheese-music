package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class MVSearchResponse {
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

    public List<MVDetail> getData() {
        return data;
    }

    public void setData(List<MVDetail> data) {
        this.data = data;
    }

    private List<MVDetail> data;
}
