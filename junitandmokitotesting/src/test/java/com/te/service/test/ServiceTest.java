package com.te.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.te.dao.EmpDao;
import com.te.dto.EmpDto;
import com.te.dto.LoginDto;
import com.te.entity.Employee;
import com.te.service.EmpService;

@SpringBootTest
public class ServiceTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private EmpService empService;
	
	@Mock
	private EmpDao dao;
	
	@BeforeEach
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(empService).build();
	}
	
	@Test
	public void registerTest() {
		EmpDto dto=new EmpDto("tyc001","12345","sushma","sush@gmail.com");
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.save(emp)).thenReturn(emp);
		assertEquals(dto, empService.register(dto));
	}
	
	@Test
	public void loginTest() {
		LoginDto dto=new LoginDto("tyc001","12345");
		EmpDto empDto=new EmpDto("tyc001","12345","sushma","sush@gmail.com");
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.findByEmpId(dto.getEmpId())).thenReturn(emp);
		assertEquals(empDto, empService.login(dto));
	}

	@Test
	public void updateTest() {
		EmpDto dto=new EmpDto("tyc001","12345","sushma","sush@gmail.com");
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.save(emp)).thenReturn(emp);
		assertEquals(dto, empService.register(dto));
	}
	
	@Test
	public void deleteTest() {
		String empId="tyc001";
		Employee emp=new Employee("tyc001","12345","sushma","sush@gmail.com");
		when(dao.findByEmpId(empId)).thenReturn(emp);
		empService.delete(empId);
		verify(dao, times(1)).deleteById(empId);
		assertEquals(true, empService.delete(empId));
	}
	
	

}
