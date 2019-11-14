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
    void insert() {
        userMapper.insert(new User("aa", "123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "123456", UserSexEnum.MAN));
    }

    @Test
    void select() {
        List<User> userList = userMapper.getAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("name--" + userList.get(i).userName);
        }
    }

    @Test
    void getOne() {
        User user = userMapper.getOne(5L);
        if (null != user) {
            System.out.println(user.userName);
        }
    }

    @Test
    void update() {
        User user = new User("bb", "123456", UserSexEnum.WOMAN, 11);
        int count = userMapper.update(user);
        System.out.println("更新数据条数：" + count);
    }

    @Test
    void delete() {
        int count = userMapper.delete(11L);
        System.out.println("删除数据条数：" + count);
    }

}
