package com.werner.ping;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner.ping
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.25 10:26
 */
public class ShiroUtils {

    public static Subject login(String configFile, String userName, String password) {
        //读取配置文件,初始化SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        //获取securityManager实例
        SecurityManager securityManager = factory.getInstance();
        //把securityManager实例绑定到securityUitls0
        SecurityUtils.setSecurityManager(securityManager);
        //得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();
        //创建 token令牌,用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        //身份异常
        try {
            currentUser.login(token);
            System.out.println("身份认证成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证失败");
        }
        return currentUser;
    }

}
