package com.vincent.springbootmybatisxmlmultidatasource.mapper.test2;


import com.vincent.springbootmybatisxmlmultidatasource.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> getAll();

//    List<User> getAll();
//
//    User getUser(long id);
//
//    int insertUser(User user);
//
//    int updateUser(User user);
//
//    int deleteUser(User user);
}
