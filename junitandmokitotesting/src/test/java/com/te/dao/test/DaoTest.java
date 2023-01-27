package com.te.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.te.dao.EmpDao;
import com.te.dto.EmpDto;
import com.te.dto.LoginDto;
import com.te.entity.Employee;

@DataJpaTest
/*@SpringBootTest*/
public class DaoTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private EmpDao dao;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(dao).build();
	}
	
	
	@Test
	private void registerTest() {
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.save(emp)).thenReturn(emp);
		assertEquals("ty001",emp);

	}
	
	@Test
	public void loginTest() {
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.findByEmpId(emp.getEmpId())).thenReturn(emp);
		assertEquals(emp, dao.findById(emp));
	}

	@Test
	public void updateTest() {
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.save(emp)).thenReturn(emp);
	}
	/*assertEquals(emp, dao.save(emp));*/
	

}
