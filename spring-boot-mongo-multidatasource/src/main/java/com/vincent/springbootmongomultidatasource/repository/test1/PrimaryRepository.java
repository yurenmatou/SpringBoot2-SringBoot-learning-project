package com.vincent.springbootmongomultidatasource.repository.test1;

import com.vincent.springbootmongomultidatasource.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<User,String > {

}
