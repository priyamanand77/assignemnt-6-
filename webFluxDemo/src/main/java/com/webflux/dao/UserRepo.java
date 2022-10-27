package com.webflux.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.webflux.model.User;

@Repository
public interface UserRepo extends ReactiveMongoRepository<User, Integer> {

}
