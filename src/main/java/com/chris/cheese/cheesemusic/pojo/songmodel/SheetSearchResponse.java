package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SheetSearchResponse {
    private String result;
    private String code;
    private List<SheetDetail> data;

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

    public List<SheetDetail> getData() {
        return data;
    }

    public void setData(List<SheetDetail> data) {
        this.data = data;
    }
}
