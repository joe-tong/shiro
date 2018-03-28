package com.werner.ping.service.Impl;

import com.werner.ping.bean.Privilege;
import com.werner.ping.mapper.PrivilegeMapper;
import com.werner.ping.service.IPrivilegeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.service.Impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.23 19:48
 */
@Service("privilegeService")
public class IPrivilegeServiceImpl implements IPrivilegeService{
    @Resource
    PrivilegeMapper privilegeMapper;
    @Override
    public List<String> selectAllUrl() {
        List<String> allUrl = privilegeMapper.selectAllUrl();
        return allUrl;
    }


    public List<Privilege> findPriByLoginname(String loginname){
        if(loginname == null ||loginname.equals("")){
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("超级管理员")){
            return privilegeMapper.selectAll();
        }
        List<Privilege> privilegeList = privilegeMapper.selectPriByLoginname(loginname);
        return privilegeList;

    }
}
