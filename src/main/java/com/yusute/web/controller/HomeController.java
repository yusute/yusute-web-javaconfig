package com.yusute.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yusutehot on 3/30/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/index.html"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
