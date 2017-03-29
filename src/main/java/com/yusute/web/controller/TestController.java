package com.yusute.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yusutehot on 3/29/2017.
 */
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
