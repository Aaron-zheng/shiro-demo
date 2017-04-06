package com.sightcorner.shiro.util;


import com.sightcorner.shiro.vo.LoginUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class ShiroRealmImpl extends AuthorizingRealm{

    public ShiroRealmImpl() {
        super();

        this.setCredentialsMatcher(new ShiroCredentialsMatcher());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权查询回调函数，进行鉴权

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //LoginUser loginUser = ShiroUtils.getLoginUser();

        List<String> roles = new ArrayList<>();
        simpleAuthorizationInfo.addRoles(roles);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //可以自定义 token

        //
        String userId = "00000001";
        String userName = "java_username";
        String userPassword = "java_password";
        LoginUser loginUser = new LoginUser(userId, userName);

        return new SimpleAuthenticationInfo(loginUser, userPassword, this.getName());
    }



}
