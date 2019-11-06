package com.vincent.springbootjpa.dao;

import com.vincent.springbootjpa.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM USER WHERE user_name = ?1",
            countQuery = "SELECT count(*) FROM USER WHERE user_name = ?1",
            nativeQuery = true)
    Page<User> findByUsername(String username, Pageable pageable);


    @Query("select u from User u where u.userName = ?1")
    User findUser(String userName);
//
//
    @Query("select u from User u")
    Page<User> findUserLists(Pageable pageable);



    @Query(value = "select u from User u where u.id=:id order by  u.id desc")
    Page<User> findRoomUidsByIdPageable(@Param("id") long id, Pageable pageable);

    Page<User> queryFirst10ById(@Param("id") long id, Pageable pageable);

    Slice<User> findTop3ById(@Param("id") long id, Pageable pageable);

    List<User> findFirst10ById(@Param("id") long id,Sort sort);

    List<User> findTop10ById(@Param("id") long id,Pageable pageable);

    Page<User> findByNickName(String nickName, Pageable pageable);

    User findByUserName(String user_name);

    User findByUserNameOrEmail(String username, String email);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String  userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(Long id);
//
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
//
    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    Slice<User> findByUserNameAndEmail(String nickName, String email,Pageable pageable);


}
