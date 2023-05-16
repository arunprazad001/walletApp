package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
   
	public User findByUserName(String name);
}
