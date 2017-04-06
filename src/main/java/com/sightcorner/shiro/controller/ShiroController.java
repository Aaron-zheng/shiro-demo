package com.sightcorner.shiro.controller;


import com.sightcorner.shiro.vo.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiroController {

    @RequestMapping(value = "/indexPage")
    public String indexPage() {
        return "index";
    }
    @RequestMapping(value = "/homePage")
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/unauthorizedPage")
    public String unauthorizedPage() {
        return "unauthorized";
    }


    @RequestMapping(value = "login")
    public @ResponseBody JsonResult login(String userName, String userPassword) {

        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        token.setRememberMe(true);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                return new JsonResult(true, "login success");
            }
        } catch (Exception ex) {

        }

        return new JsonResult(true, "login fail");
    }

    @RequestMapping(value = "logout")
    public @ResponseBody JsonResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new JsonResult(true, "logout success");
    }
}
