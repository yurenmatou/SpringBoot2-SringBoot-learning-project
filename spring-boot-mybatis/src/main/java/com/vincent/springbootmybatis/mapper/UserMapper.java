package com.vincent.springbootmybatis.mapper;

import com.vincent.springbootmybatis.model.User;
import com.vincent.springbootmybatis.model.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {



    @Select("select * from user")
    public List<User> getAllEntity();


    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("INSERT INTO user(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int delete(Long id);

}
