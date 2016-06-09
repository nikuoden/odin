package com.odin.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odin.management.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
}