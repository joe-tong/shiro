package com.werner.ping.controller;

import com.github.pagehelper.PageInfo;
import com.werner.ping.bean.User;
import com.werner.ping.common.Const;
import com.werner.ping.service.IUserService;
import com.werner.ping.vo.DeptAndRole;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.22 15:46
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Resource
    IUserService iUserService;

    @RequestMapping("page_info")
    public String pageInfo(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
        PageInfo pageInfo = iUserService.selectUserList(pageSize, pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "pages/frame/xitong/list_users";
    }

    @RequestMapping("page_info2")
    @ResponseBody
    public PageInfo pageInfo2(Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = iUserService.selectUserList(pageSize, pageNum);
        return pageInfo;
    }

@RequiresPermissions(value = {"user/add_user"})
    @RequestMapping("add_user")
    public String addUser() {
        Subject sub = SecurityUtils.getSubject();
//        //如果当前用户没有这项权利,但是从浏览器中直接从路径请求,这是判断是否有该项权利
//        if (!sub.isPermitted("user/add_user")) {
//            return "no_pri";
//        }
        Session session = sub.getSession();
        String loginname = (String) session.getAttribute(Const.CURRENT_USER);
        System.out.println(loginname+":拥有这项add_user权利");
        return "pages/frame/xitong/add_user";
    }

    @RequestMapping("show_dept_and_role")
    @ResponseBody
    public DeptAndRole showDeptAndRole() {
        DeptAndRole dr = iUserService.selectDeptAndRole();
        return dr;
    }
}
