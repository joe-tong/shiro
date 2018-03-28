package com.werner.ping.service;

import com.werner.ping.bean.Privilege;

import java.util.List;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.23 19:47
 */
public interface IPrivilegeService {
     List<String> selectAllUrl();
     List<Privilege> findPriByLoginname(String loginname);

}
