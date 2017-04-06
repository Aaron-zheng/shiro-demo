package com.sightcorner.shiro.util;


import com.sightcorner.shiro.vo.LoginUser;
import org.apache.shiro.SecurityUtils;

public class ShiroUtils {

    public static LoginUser getLoginUser() {
        return (LoginUser) SecurityUtils.getSubject().getPrincipal();
    }


    public static void logout() {
        SecurityUtils.getSubject().logout();
    }


}
