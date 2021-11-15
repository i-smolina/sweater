package com.example.sweater.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sweater.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
