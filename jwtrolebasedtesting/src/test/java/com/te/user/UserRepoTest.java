package com.te.user;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.te.repo.UserRepository;
import com.te.users.Role;
import com.te.users.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepoTest {

	@Autowired
	UserRepository repo;

	@Test
	void testCreateUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String raw = "skb123";
		String encoded = passwordEncoder.encode(raw);
		User user = new User("skb110209@gmail.com", encoded);
		User savedUser = repo.save(user);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	void testAssignRolesToUser() {
		Integer userId=14;
		
		User user=repo.findById(userId).get();
		user.addRole(new Role(1));
		
		User updatedUser = repo.save(user);
		assertThat(updatedUser.getRoles()).hasSize(1);
		
	}
	
	
	
	
	
	

}
