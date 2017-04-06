package com.sightcorner.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleShiroApplication {

    private static final transient Logger logger = LoggerFactory.getLogger(SimpleShiroApplication.class);

    /**
     * Application code -> Subject -> Shiro security manager -> realm
     * Shiro 提供了多种 Realms 去连接数据源，如 LDAP，数据库（JDBC），文本配置文件（如INI）
     */
    public static void main(String[] args) {
        logger.info("this is shiro application.");

        SimpleShiroApplication application = new SimpleShiroApplication();
        application.proceed();

        System.exit(0);
    }


    private void proceed() {
        
        //1 security manager
        this.initialSecurityManager();
        
        //2 session
        Subject currentUser = SecurityUtils.getSubject();
        
        //3 session
        this.initialSession(currentUser);
        
        //4 login
        this.initialLogin(currentUser);
        
        //5 role
        this.initialRole(currentUser);
        
        //6 permission
        this.initialPermission(currentUser);

        //7 logout
        this.initialLogout(currentUser);
    }

    private void initialLogout(Subject currentUser) {
        logger.info("用户登出");
        currentUser.logout();
    }

    private void initialPermission(Subject currentUser) {
        if(currentUser.isPermitted("lightsaber:weild")) {
            logger.info("有该权限");
        } else {
            logger.info("没有权限");
        }

        if(currentUser.isPermitted("winnebago:drive:eagle5")) {
            logger.info("有该权限");
        } else {
            logger.info("没有权限");
        }
    }

    private void initialRole(Subject currentUser) {
        if(currentUser.hasRole("schwartz")) {
            logger.info("有该角色");
        } else {
            logger.info("没有角色");
        }

    }

    private void initialLogin(Subject currentUser) {

        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);

            try{
                currentUser.login(token);
                this.initialLogin(currentUser);
            }catch(UnknownAccountException ex) {
                logger.info("没有该用户名" + token.getPrincipal());
            }catch (IncorrectCredentialsException ex) {
                logger.info("密码错误" + token.getPrincipal());
            }catch (LockedAccountException ex) {
                logger.info("用户名被锁");
            }catch (AuthenticationException ex) {
                logger.info("未知错误");
            }
        } else {
            logger.info("用户登录成功" + currentUser.getPrincipal());
        }
    }

    private void initialSession(Subject currentUser) {
        Session session = currentUser.getSession();
        session.setAttribute("nameKey", "nameValue");

        String value = (String) session.getAttribute("nameKey");

        if(value.equals("nameValue")) {
            logger.info("value: " + value);
        }
    }


    private void initialSecurityManager() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }



}
