package com.vincent.repository.test1;

import com.vincent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrimaryRepository extends JpaRepository<User, Long> {

    User findById(long id);
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);

}
