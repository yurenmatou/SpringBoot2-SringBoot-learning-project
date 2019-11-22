package com.vincent.springbootmybatisxml.mapper;

import com.vincent.springbootmybatisxml.model.User;

import java.util.List;

public interface UserMapper {

    List<User> getAll();

    User getUser(long id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);
}
