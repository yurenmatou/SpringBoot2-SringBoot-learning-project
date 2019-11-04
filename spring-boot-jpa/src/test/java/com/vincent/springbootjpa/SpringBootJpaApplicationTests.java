package com.vincent.springbootjpa;

import com.vincent.springbootjpa.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootJpaApplicationTests {

    @Resource
    private UserRepository repository;

    @Test
    void contextLoads() {
        System.out.println(repository.findAll());
    }

}
