package com.example.demo.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
