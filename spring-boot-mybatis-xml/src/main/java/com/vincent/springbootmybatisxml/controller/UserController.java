package com.vincent.springbootmybatisxml.controller;


import com.vincent.springbootmybatisxml.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping
    public User getUser() {
        return new User(1,"xiaohu");
    }

}
