package com.vincent.springbootjpa.service;

import com.vincent.springbootjpa.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAllUser();

    void saveUser(User user);

    User findUser(String userName);
}
