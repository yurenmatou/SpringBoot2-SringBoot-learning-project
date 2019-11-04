package com.vincent.springbootjpa.dao;

import com.vincent.springbootjpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class UserRepolicy implements JpaRepository<User, Long> {


    
}
