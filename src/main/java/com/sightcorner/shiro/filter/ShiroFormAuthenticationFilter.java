package com.sightcorner.shiro.filter;


import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {


    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String userName = this.getUsername(request);
        String userPassword = this.getPassword(request);
        boolean isRememberMe = false;
        String host = this.getHost(request);
        return new UsernamePasswordToken(userName, userPassword, isRememberMe, host);
    }


}
