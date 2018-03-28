package com.werner.ping.util;

import com.werner.ping.bean.Privilege;
import com.werner.ping.bean.User;
import com.werner.ping.common.Const;
import com.werner.ping.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner.ping.util
 * @Description:
 * *步骤:
 * 1.通过传过来的token得到登录账户,从数据库中查出是否有这个用户,
 * 2.如果有,通过SimpleAuthenticationInfo来判断密码是否正确,如果正确,进入授权authorization
 * 3.通过getPrimaryPrincipal()同样得到登录账户,通过账户得到用户权限,赋予当前用户权限
 * @date 2017.11.25 14:28
 */
@Service
public class MyRealm extends AuthorizingRealm {
    @Resource
    IUserService iUserService;

    /**
     * 为当前登陆成功用户授予角色和权限
     *
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String loginname = (String) principal.getPrimaryPrincipal();
        User user = iUserService.findUserByLoginname(loginname);
        //查询出来的角色和权限都放在这个info里面
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加角色(这里是一个用户一个角色;addRoles:一个用户多个角色)
        info.addRole(user.getRole().getRoleCn());

        List<Privilege> privilegeList = user.getRole().getPrivilegeList();
        ArrayList<String> urls = new ArrayList<>();
        for (int i = 0; i < privilegeList.size(); i++) {
            Privilege privilege = privilegeList.get(i);
            if (privilege.getPriUrl() != null) {
                urls.add(privilege.getPriUrl());
            }
        }
        //添加权限
        info.addStringPermissions(urls);

        return info;
    }

    /**
     * 验证当前登陆的用户
     * 步骤:
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //这里要求用户账号是唯一的
        String loginname = (String) token.getPrincipal();
        User user = iUserService.findUserByLoginname(loginname);
       if(user == null){
           throw new UnknownAccountException("账户不存在");
       }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginname, user.getLoginpwd(), this.getClass().getName());
        Subject sub = SecurityUtils.getSubject();
        Session session = sub.getSession();
        session.setAttribute(Const.CURRENT_USER,loginname);
        return info;
    }
}
