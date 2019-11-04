package com.vincent.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {


    @RequestMapping("/index")
    public String hello(){
        return "你好啊";
    }
}
