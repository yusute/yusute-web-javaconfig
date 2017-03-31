package com.yusute.web.controller;

import com.yusute.web.mapper.po.User;
import com.yusute.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yusutehot on 3/29/2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Login form
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
