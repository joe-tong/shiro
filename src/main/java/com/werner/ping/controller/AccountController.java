package com.werner.ping.controller;

import com.werner.ping.bean.User;
import com.werner.ping.common.Const;
import com.werner.ping.service.IAccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.21 16:15
 */
@Controller
@RequestMapping("/account/")
public class AccountController {
    @Resource(name = "iAccountService")
    IAccountService iAccountService;

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        System.out.println("checklogin...");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginname(), user.getLoginpwd());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
          return "index";
        }catch (IncorrectCredentialsException e){
            return "index";
        }
        return "pages/main";
    }
    @RequestMapping("logout")
    public String logout() {
        System.out.println("logout...");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
}
