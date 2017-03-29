package com.yusute.web.service;

import com.yusute.web.mapper.po.User;

/**
 * Created by yusutehot on 3/29/2017.
 */
public interface UserService {

    User loadUserByUsername(String username);

    void saveUser(User user);
}
