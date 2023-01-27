package com.te.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.users.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer>{

}
