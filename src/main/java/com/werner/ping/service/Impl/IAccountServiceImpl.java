package com.werner.ping.service.Impl;

import com.werner.ping.bean.User;
import com.werner.ping.mapper.PrivilegeMapper;
import com.werner.ping.mapper.UserMapper;
import com.werner.ping.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 童平平
 * @Title: prilivilegeDemo
 * @Package com.werner.ping.service.Impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017.11.21 16:17
 */
@Service("iAccountService")
public class IAccountServiceImpl implements IAccountService {
    @Resource
    UserMapper userMapper;
    @Resource
    PrivilegeMapper privilegeMapper;
    public User login(User user){
        User u = userMapper.selectByUsernameAndPassword(user);
        if (u != null && u.checkRole()){
            u.getRole().setPrivilegeList(privilegeMapper.selectAll());
        }
        return u;
    }

}
