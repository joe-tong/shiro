package com.werner.ping;


import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.25 10:24
 */

/**
 * 基于role的授权
 */
public class ShiroRoleDemo {
    @Test
    public void testHasRole() {
        Subject currentUser = ShiroUtils.login("classpath:config/shiro_role.ini", "java1234", "123456");
        System.out.println(currentUser.hasRole("role1") ? "有role这个角色" : "没有这个role角色");
        boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));
        System.out.println(results[0] ? "有role1这个角色" : "没有这个role角色");
        System.out.println(results[1] ? "有role2这个角色" : "没有这个role角色");
        System.out.println(results[2] ? "有role3这个角色" : "没有这个role角色");
        System.out.println(currentUser.hasAllRoles(Arrays.asList("role1", "role2")) ? "有role1,role2都这些角色" : "没有这个role1,role2不全有角色");


    }

    @Test
    public void testCheckRole() {
        Subject currentUser = ShiroUtils.login("classpath:config/shiro_role.ini", "java1234", "123456");
        currentUser.checkRole("role2");
        currentUser.checkRoles(Arrays.asList("role1", "role2"));

    }

}
