package com.vincent.springbootjpa.dao;

import com.vincent.springbootjpa.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;


public interface   UserRepository extends JpaRepository<User, Long> {



    @Query("select u from User u where u.userName = ?1")
    public User findUser(String userName);



    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    Page<User> findByNickName(String nickName, Pageable pageable);

    Slice<User> findByNickNameAndEmail(String nickName, String email, Pageable pageable);
}
