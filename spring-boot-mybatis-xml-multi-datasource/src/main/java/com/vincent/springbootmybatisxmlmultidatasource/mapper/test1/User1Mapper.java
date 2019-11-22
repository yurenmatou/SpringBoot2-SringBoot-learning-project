package com.vincent.springbootmybatisxmlmultidatasource.mapper.test1;


import com.vincent.springbootmybatisxmlmultidatasource.model.User;

import java.util.List;

public interface User1Mapper {

    List<User> getAll();

    User getUser(long id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
