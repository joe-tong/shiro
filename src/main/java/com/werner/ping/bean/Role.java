package com.werner.ping.bean;

import java.util.List;

public class Role {
    private Integer roleid;

    private String roleCn;

    private String roleEn;

    private String roleDesc;

    private String roleStatus;
    private List<Privilege> privilegeList;

    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRoleCn() {
        return roleCn;
    }

    public void setRoleCn(String roleCn) {
        this.roleCn = roleCn == null ? null : roleCn.trim();
    }

    public String getRoleEn() {
        return roleEn;
    }

    public void setRoleEn(String roleEn) {
        this.roleEn = roleEn == null ? null : roleEn.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus == null ? null : roleStatus.trim();
    }
}