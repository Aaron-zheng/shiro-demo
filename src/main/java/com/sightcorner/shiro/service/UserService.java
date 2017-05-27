package com.sightcorner.shiro.service;


import com.sightcorner.shiro.entity.User;

public interface UserService {

    User isExist(String name, String password);
}
