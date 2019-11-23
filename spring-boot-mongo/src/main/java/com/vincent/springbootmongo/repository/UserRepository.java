package com.vincent.springbootmongo.repository;


import com.vincent.springbootmongo.model.User;

import java.util.List;

public interface UserRepository {


     List<User> select();
      User selectOne(String userName);
     long update(User id);
     User insert(User user);
     long delete(long id);
}
