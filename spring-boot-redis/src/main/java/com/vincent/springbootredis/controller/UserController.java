package com.vincent.springbootredis.controller;


import com.vincent.springbootredis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class UserController {


    @RequestMapping("/getUser")
    @Cacheable(value = "test-user-key")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setPassword("123456");
        user.setUserName("小名儿");
        user.setRegTime(System.currentTimeMillis() + "");
        return user;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("aid");
        System.out.println("UUID=" + uid);
        if (uid == null) {
            uid = UUID.randomUUID();
            System.out.println("uid=" + uid);
        }
        System.out.println("aid=" + uid);
        session.setAttribute("aid", uid);
        return session.getId();
    }
}
