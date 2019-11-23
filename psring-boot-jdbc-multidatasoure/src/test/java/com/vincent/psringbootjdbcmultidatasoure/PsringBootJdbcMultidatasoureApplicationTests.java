package com.vincent.psringbootjdbcmultidatasoure;

import com.vincent.psringbootjdbcmultidatasoure.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class PsringBootJdbcMultidatasoureApplicationTests {

    @Autowired
    @Qualifier("jdbcTemplate1")
    JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("jdbcTemplate2")
    JdbcTemplate jdbcTemplate2;

    @Test
    void contextLoads() {
    }

    @Test
    void select() {
        List<User> userList = jdbcTemplate1.query("select * from user", new BeanPropertyRowMapper<>());
        if (null == userList || userList.size() <= 0) {
            System.out.println("null");
        } else {
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i).getUserName());
            }
        }
    }


    @Test
    void select2() {
        List<User> userList = jdbcTemplate2.query("select * from user", new BeanPropertyRowMapper<>());
        if (null == userList || userList.size() <= 0) {
            System.out.println("null");
        } else {
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i).getUserName());
            }
        }
    }


}
