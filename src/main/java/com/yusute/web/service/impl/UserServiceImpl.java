package com.yusute.web.service.impl;

import com.yusute.web.mapper.UserMapper;
import com.yusute.web.mapper.po.User;
import com.yusute.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yusutehot on 3/29/2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

}
