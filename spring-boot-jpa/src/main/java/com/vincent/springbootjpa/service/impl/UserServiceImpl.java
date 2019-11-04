package com.vincent.springbootjpa.service.impl;

import com.vincent.springbootjpa.bean.User;
import com.vincent.springbootjpa.dao.UserRepository;
import com.vincent.springbootjpa.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository repository;

    @Override
    public List<User> findAllUser() {
        return repository.findAll();
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public User findUser(String userName) {
        return  repository.findUser(userName);
    }
}
