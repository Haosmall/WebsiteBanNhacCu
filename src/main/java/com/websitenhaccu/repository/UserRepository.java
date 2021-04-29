package com.websitenhaccu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	public User findByEmail(String email);
}
