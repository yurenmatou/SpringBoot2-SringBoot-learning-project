package com.vincent.springbootmybatisxml.mapper;

import com.vincent.springbootmybatisxml.model.User;
import com.vincent.springbootmybatisxml.model.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {


    @Autowired
    UserMapper userMapper;


    @Test
    public void insert() {
        System.out.println(userMapper.insertUser(new User("aaa", "123456", UserSexEnum.MAN)));
        System.out.println(userMapper.insertUser(new User("bbb", "123456", UserSexEnum.MAN)));
        System.out.println(userMapper.insertUser(new User("ccc", "123456", UserSexEnum.MAN)));
    }

    @Test
    public void getAll() {
        List<User> userList = userMapper.getAll();
        if (userList.size() > 0) {
            User user = userMapper.getUser(userList.get(0).id);
            System.out.println(user.userName);
        }
    }

    @Test
    public void updateUser() {
        userMapper.updateUser(new User("cccc", "1234567", UserSexEnum.WOMAN, 8));
    }

    @Test
    public void deleteUser() {
        System.out.println(userMapper.deleteUser(new User("cccc", "1234567", UserSexEnum.WOMAN, 8)));
    }
}
