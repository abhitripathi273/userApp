package com.microservices.user.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.user.app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
