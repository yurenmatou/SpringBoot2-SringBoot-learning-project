package com.vincent.springbootmybatismulidatasource.mapper.test1;

import com.vincent.springbootmybatismulidatasource.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();
}
