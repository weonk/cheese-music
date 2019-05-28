package com.chris.cheese.cheesemusic.pojo.songmodel;

import java.util.List;

public class SheetCreator {
    private String nickname;
    private String userId;
    private String userType;
    private String authStatus;
    private List<String> expertTags;
    private Object experts;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public List<String> getExpertTags() {
        return expertTags;
    }

    public void setExpertTags(List<String> expertTags) {
        this.expertTags = expertTags;
    }

    public Object getExperts() {
        return experts;
    }

    public void setExperts(Object experts) {
        this.experts = experts;
    }
}
