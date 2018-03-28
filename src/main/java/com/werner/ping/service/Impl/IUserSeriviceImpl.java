package com.werner.ping.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.werner.ping.bean.Dept;
import com.werner.ping.bean.Privilege;
import com.werner.ping.bean.Role;
import com.werner.ping.bean.User;
import com.werner.ping.mapper.DeptMapper;
import com.werner.ping.mapper.PrivilegeMapper;
import com.werner.ping.mapper.RoleMapper;
import com.werner.ping.mapper.UserMapper;
import com.werner.ping.service.IUserService;
import com.werner.ping.vo.DeptAndRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.service.Impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.22 15:48
 */
@Service
public class IUserSeriviceImpl implements IUserService {
    @Resource
    UserMapper userMapper;
    @Resource
    DeptMapper deptMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    PrivilegeMapper privilegeMapper;

    public PageInfo selectUserList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectAll();
        PageInfo info = new PageInfo<User>(userList);
        return info;
    }

    public List<Dept> selectDeptAll() {
        return deptMapper.selectAllDept();
    }

    public List<Role> selectRoleAll() {
        return roleMapper.selectRoleAll();
    }

    public DeptAndRole selectDeptAndRole() {
        DeptAndRole deptAndRole = new DeptAndRole();
        deptAndRole.setDeptList(this.selectDeptAll());
        deptAndRole.setRoleList(this.selectRoleAll());
        return deptAndRole;
    }

    public User findUserByLoginname(String loginname) {
        if (loginname == null || loginname.equals("")) {
            return null;
        }
        User user = userMapper.findUserByLoginname(loginname);
        if (user != null && user.checkRole()) {
            List<Privilege> privilegeList = privilegeMapper.selectAll();
            Role role = user.getRole();
            role.setPrivilegeList(privilegeList);
            user.setRole(role);
        }
        return user;
    }
}
