package com.vincent.springbootmybatismulidatasource.mapper.test3;

import com.vincent.springbootmybatismulidatasource.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper3 {

    @Select("select * from user")
    List<User> getUsers();
}
