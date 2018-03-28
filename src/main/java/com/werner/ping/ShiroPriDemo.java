package com.werner.ping;

import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner.ping
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.25 10:56
 */

/**
 * 基于权限认证
 */
public class ShiroPriDemo {
    @Test
    public  void testPermitted(){
        Subject currentUser = ShiroUtils.login("classpath:config/shiro_permission.ini", "java1234", "123456");
        System.out.println(currentUser.isPermitted("user:select")?"有user:select这个权限":"没有User:select这个权限");
        System.out.println(currentUser.isPermitted("user:update")?"有user:select这个权限":"没有User:select这个权限");
        boolean permittedAll = currentUser.isPermittedAll("user:select", "user:update");
        System.out.println("这些用户都有这些权限"+permittedAll);
        boolean[] permitted = currentUser.isPermitted("user:select", "user:update");
        System.out.println(permitted[0]?"有这项权利":"没有这项权利");
        System.out.println(permitted[1]?"有这项权利":"没有这项权利");
        currentUser.logout();
    }
    @Test
    public  void checkPermission(){
        Subject currentUser = ShiroUtils.login("classpath:config/shiro_permission.ini", "java1234", "123456");
        currentUser.checkPermission("user:select");
        currentUser.checkPermissions("user:select", "user:update");
    }
}
