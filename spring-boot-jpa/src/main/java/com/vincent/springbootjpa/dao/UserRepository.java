package com.vincent.springbootjpa.dao;

import com.vincent.springbootjpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface   UserRepository extends JpaRepository<User, Long> {



}
