package com.vincent.springbootmongo.repository;


import com.vincent.springbootmongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;


    @Test
    public void select() {
        List<User> userList = userRepository.select();
        if (userList == null || userList.size() <= 0) {
            System.out.println("userList is null");
        } else {
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i).getId());
            }
        }
//        userList.get(0).getNickName();
    }

    @Test
    public void selectOne() {
        User user = userRepository.selectOne("小");
        if (null != user) {
            System.out.println(user.getUserName());
        } else {
            System.out.println("null");
        }
    }


    @Test
    public void insert() {
        long id = 1;
        List<User> userList = userRepository.select();
        if (null != userList && userList.size() > 0) {
            id = userList.get(userList.size() - 1).getId() + 1;
        }
        User user = new User();
        user.setId(id);
        user.setNickName("兜兜"+id);
        user.setUserName("蜡笔小新"+id);
        user.setPassWord("123456"+id);
        User saveUser = userRepository.insert(user);
        if (null != saveUser) {
            System.out.println("已经保存：" + user.getUserName());
        } else {
            System.out.println("null");
        }
    }


    @Test
    public void delete() {
        long id = userRepository.delete(22);
        if (id > 0) {
            System.out.println("删除ID：" + id);
        } else {
            System.out.println("null");
        }
    }


    @Test
    public void update() {
        User user = new User();
        user.setId(2);
        user.setNickName("兜兜");
        user.setUserName("蜡笔小新");
        user.setPassWord("123456");
        long id = userRepository.update(user);
        if (id > 0) {
            System.out.println("更新ID：" + id);
        } else {
            System.out.println("null");
        }
    }


}
