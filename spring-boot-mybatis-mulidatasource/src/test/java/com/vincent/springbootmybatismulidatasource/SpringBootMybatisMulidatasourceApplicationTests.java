package com.vincent.springbootmybatismulidatasource;

import com.vincent.springbootmybatismulidatasource.mapper.test1.UserMapper;
import com.vincent.springbootmybatismulidatasource.mapper.test2.User2Mapper;
import com.vincent.springbootmybatismulidatasource.mapper.test3.UserMapper3;
import com.vincent.springbootmybatismulidatasource.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisMulidatasourceApplicationTests {


    @Autowired
    UserMapper userMapper;


    @Autowired
    User2Mapper userMapper2;


    @Autowired
    UserMapper3 userMapper3;


    @Test
    void contextLoads() {
    }

    @Test
    void getAll() {
        List<User> userList = userMapper.getUsers();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).userName);
        }
    }

    @Test
    void getAll2() {
        List<User> userList = userMapper2.getAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).userName);
        }
    }


    @Test
    void getAll3() {
        List<User> userList = userMapper3.getUsers();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).userName);
        }
    }


}
