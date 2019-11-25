package com.vincent.springbootmongomultidatasource.repository;

import com.vincent.springbootmongomultidatasource.model.User;
import com.vincent.springbootmongomultidatasource.repository.test1.PrimaryRepository;
import com.vincent.springbootmongomultidatasource.repository.test2.SecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MuliDatabaseTest {

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    private SecondaryRepository secondaryRepository;

    @Test
    public void TestSave() {
        this.primaryRepository.save(new User("币多多", "123456"));
        this.secondaryRepository.save(new User("钱多多", "654321"));
        List<User> primaries = this.primaryRepository.findAll();
        for (User primary : primaries) {
            System.out.println(primary.toString());
        }
        List<User> secondaries = this.secondaryRepository.findAll();
        for (User secondary : secondaries) {
            System.out.println(secondary.toString());
        }
    }

}
