package com.werner.ping.mapper;

import com.werner.ping.bean.User;

import java.util.List;

public interface UserMapper {
    User selectByUsernameAndPassword(User user);

    List<User> selectAll();

    User findUserByLoginname(String loginname);
}