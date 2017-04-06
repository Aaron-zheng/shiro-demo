package com.sightcorner.shiro.vo;


import java.io.Serializable;
import java.sql.Timestamp;

public class LoginUser implements Serializable {

    private String userId;
    private String userName;
    private Timestamp loginTime;

    public LoginUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.loginTime = new Timestamp(System.currentTimeMillis());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }
}
