package com.sightcorner.shiro.service;


import com.sightcorner.shiro.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User isExist(String name, String password) {

        if(null != name && null != password) {
            if(name.equals("Aaron") && password.equals("123456")) {
                return new User("Aaron", "123456", "admin,guest");
            }
        }

        return null;
    }
}
