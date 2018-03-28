package com.werner.ping.mapper;

import com.werner.ping.bean.Role;

import java.util.List;

public interface RoleMapper {
 Role selectByRoleId(Integer roleId);
 List<Role> selectRoleAll();
 }