package com.werner.ping.vo;

import com.werner.ping.bean.Dept;
import com.werner.ping.bean.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.22 23:16
 */
public class DeptAndRole implements Serializable {
    private List<Dept> deptList;
    private List<Role> roleList;

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
