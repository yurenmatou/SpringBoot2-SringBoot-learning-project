package com.vincent.springbootmybatismulidatasource.mapper.test2;

import com.vincent.springbootmybatismulidatasource.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface User2Mapper {

    @Select("select * from user")
    List<User> getAll();
}
