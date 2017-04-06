package com.sightcorner.shiro.util;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class ShiroCredentialsMatcher extends SimpleCredentialsMatcher{

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Object accountCredentials = this.getCredentials(info);

        return this.equals(token.getPassword(), accountCredentials);

    }
}
