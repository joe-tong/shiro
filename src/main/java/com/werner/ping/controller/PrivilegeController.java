package com.werner.ping.controller;

import com.werner.ping.bean.Privilege;
import com.werner.ping.common.Const;
import com.werner.ping.service.IPrivilegeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 童平平
 * @Title: shiro
 * @Package com.werner.ping.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.25 16:17
 */
@Controller
@RequestMapping("/pc/")
public class PrivilegeController {
    @Resource
    private IPrivilegeService iPrivilegeService;

    @RequestMapping(value = "findPriByLoginname")
    public String findPriByLoginname(Model model) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String loginname = (String) session.getAttribute(Const.CURRENT_USER);
        List<Privilege> privilegeList = iPrivilegeService.findPriByLoginname(loginname);
        model.addAttribute("privilegeList", privilegeList);
        model.addAttribute("loginname", loginname);
        return "pages/frame/left";

    }

}
