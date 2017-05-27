package com.sightcorner.shiro.entity;


public class User {

    public User(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
    }

    private String name;
    private String password;
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
