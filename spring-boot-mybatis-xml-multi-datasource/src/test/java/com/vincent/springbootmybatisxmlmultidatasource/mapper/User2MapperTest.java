package com.vincent.springbootmybatisxmlmultidatasource.mapper;


import com.vincent.springbootmybatisxmlmultidatasource.mapper.test2.UserMapper;
import com.vincent.springbootmybatisxmlmultidatasource.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User2MapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void query(){
        List<User> userList = userMapper.getAll();
    }
}
