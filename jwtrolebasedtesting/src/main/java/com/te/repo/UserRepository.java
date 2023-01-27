package com.te.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.users.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

}
