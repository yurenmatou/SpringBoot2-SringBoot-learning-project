package com.vincent.springbootmybatis.model;

import com.vincent.springbootmybatis.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {



    @Select("select * from user")
    public List<User> getAllEntity();

}
