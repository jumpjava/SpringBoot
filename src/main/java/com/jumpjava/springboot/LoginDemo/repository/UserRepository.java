package com.jumpjava.springboot.LoginDemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jumpjava.springboot.LoginDemo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
