package com.vincent.springbootjpa.dao;

import com.vincent.springbootjpa.bean.User;
import com.vincent.springbootjpa.bean.UserDetail;
import com.vincent.springbootjpa.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail, Long> {


//    @Query("select u.userName as userName, d.hobby as hobby from User u , UserDetail d " +
//            "where u.id=d.userId")

    @Query( "select u.userName as userName, d.hobby as hobby from User u , UserDetail d where u.id=d.userId and d.hobby like CONCAT('%',:hobby,'%')" )
    List<UserInfo> findUserWithUserDetail(@Param("hobby") String hobby);

    @Query("select d.hobby as hobby from UserDetail d ")
    List<UserInfo> findUserWithUserDetail();


    @Query("select u from UserDetail u where u.hobby = ?1")
    List<UserDetail> findUser(String hobby);

}
