package com.vincent.springbootmybatis;

import com.vincent.springbootmybatis.model.User;
import com.vincent.springbootmybatis.mapper.UserMapper;
import com.vincent.springbootmybatis.model.UserSexEnum;
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
        System.out.println("deleteid=" + userMapper.delete(1L));
        userMapper.insert(new User("aa","123456", UserSexEnum.NAN));
    }

}
