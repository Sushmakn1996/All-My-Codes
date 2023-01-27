package com.te.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.te.repo.RoleRepository;
import com.te.users.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class RoleRepoTest {

	@Autowired
	private RoleRepository repo;

	@Test
	void testCreateRoles() {
		Role admin=new Role("Role_admin");
		Role editor=new Role("Role_editor");
		Role customer=new Role("Role_customer");
		
		repo.saveAll(List.of(admin,editor,customer));
		
		long number = repo.count();
		assertEquals(3, number);
		
	}
	
	
	@Test
	void testListRoles() {
		List<Role> listRoles = repo.findAll();
		assertThat(listRoles.size()).isGreaterThan(0);
		listRoles.forEach(System.out::println);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
