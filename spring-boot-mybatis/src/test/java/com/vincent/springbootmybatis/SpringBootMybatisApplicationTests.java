package com.vincent.springbootmybatis;

import com.vincent.springbootmybatis.bean.User;
import com.vincent.springbootmybatis.model.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    void contextLoads() {

    }


    @Test
    void test() {
        List<User> userList = userMapper.getAllEntity();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("name--" + userList.get(i).nickName);
        }
    }

}
