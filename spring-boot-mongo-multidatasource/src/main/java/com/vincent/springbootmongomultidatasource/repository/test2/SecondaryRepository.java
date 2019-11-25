package com.vincent.springbootmongomultidatasource.repository.test2;

import com.vincent.springbootmongomultidatasource.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SecondaryRepository extends MongoRepository<User, String> {

}
