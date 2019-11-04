package com.vincent.springbootjpa.service;

import com.vincent.springbootjpa.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    public List<User> findAllUser();
    public void saveUser(User user);
    public User findUser(String userName);
}
