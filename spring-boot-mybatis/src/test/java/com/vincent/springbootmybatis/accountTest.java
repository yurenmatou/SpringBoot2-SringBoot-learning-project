package com.vincent.springbootmybatis;


import com.vincent.springbootmybatis.mapper.AccountMapper;
import com.vincent.springbootmybatis.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class accountTest {


    @Autowired
    private AccountMapper userMapper;


    @Test
    void insert() {
        userMapper.insert(new Account("aa", 234));
        userMapper.insert(new Account("bb", 345));
        userMapper.insert(new Account("cc", 456));
    }

    @Test
    void select() {
        List<Account> userList = userMapper.getAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("name--" + userList.get(i).getName());
        }
    }

    @Test
    void getOne() {
        Account user = userMapper.getOne(1);
        if (null != user) {
            System.out.println(user.getName());
        }
    }

    @Test
    void update() {
        int count = userMapper.update("bb", 2000, 1);
        System.out.println("更新数据条数：" + count);
    }

    @Test
    void delete() {
        int count = userMapper.delete(3);
        System.out.println("删除数据条数：" + count);
    }
}
