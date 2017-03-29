package com.yusute.web.controller;

import com.yusute.web.mapper.po.User;
import com.yusute.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yusutehot on 3/29/2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        User user = userService.loadUserByUsername("admin");
        return "index";
    }
}
