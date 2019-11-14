package com.vincent.springbootmybatis.mapper;

import com.vincent.springbootmybatis.model.Account;
import com.vincent.springbootmybatis.model.User;
import com.vincent.springbootmybatis.model.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface AccountMapper {

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    Account findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account")
    List<Account> findAccountList();


    @Insert("INSERT INTO account(name,money) VALUES(#{name}, #{money})")
    void insert(Account user);

    @Select("SELECT * FROM account")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column = "money", property = "money"),
            @Result(column = "name",property = "name")
    })
    List<Account> getAll();


    @Select("SELECT * FROM account WHERE id = #{id}")
//    @Results({
//            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
//            @Result(property = "nick_name", column = "nickName")
//    })
    Account getOne(int id);


//    @Update("UPDATE account SET name=#{name},money=#{money} WHERE id =#{id}")
//    int update(Account account);

//    @Delete("DELETE FROM account WHERE id =#{id}")
//    int delete(Long id);
}
