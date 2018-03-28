package com.werner.ping.mapper;

import com.werner.ping.bean.Privilege;

import java.util.List;

public interface PrivilegeMapper {
    List<Privilege> selectByRoleId(Integer roleId);
    List<Privilege> selectAll();
    List<String> selectAllUrl ();
    List<Privilege> selectPriByLoginname(String loginname);
}