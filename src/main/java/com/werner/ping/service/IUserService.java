package com.werner.ping.service;

import com.github.pagehelper.PageInfo;
import com.werner.ping.bean.User;
import com.werner.ping.vo.DeptAndRole;

public interface IUserService {
   PageInfo selectUserList(Integer pageSize, Integer pageNum);
   DeptAndRole selectDeptAndRole();
   User findUserByLoginname(String loginname);
}
