package com.microservices.user.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.user.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
