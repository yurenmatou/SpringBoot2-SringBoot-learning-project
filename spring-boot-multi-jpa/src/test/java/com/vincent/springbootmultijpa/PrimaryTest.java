package com.vincent.springbootmultijpa;


import com.vincent.model.User;
import com.vincent.repository.test1.PrimaryRepository;
import com.vincent.repository.test2.SecondRepository;
import com.vincent.repository.test3.ThreeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimaryTest {

    @Resource
    private PrimaryRepository primaryRepository;


    @Resource
    private SecondRepository secondRepository;


    @Resource
    private ThreeRepository threeRepository;


    @Test
    public void primaryTest() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        primaryRepository.save(new User("aaa", "aaa123456", "aaa@126.com", "aaa", formattedDate));
        primaryRepository.save(new User("bbb", "bbb123456", "bbb@126.com", "bbb", formattedDate));
    }


    @Test
    public void secondTest() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        secondRepository.save(new User("aaa", "aaa123456", "aaa@126.com", "aaa", formattedDate));
        secondRepository.save(new User("bbb", "bbb123456", "bbb@126.com", "bbb", formattedDate));
        List<User> userList = secondRepository.findAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getNickName());
        }
    }


    @Test
    public void threeTest() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        threeRepository.save(new User("bbb", "bbb123456", "bbb@126.com", "bbb", formattedDate));
    }


}
