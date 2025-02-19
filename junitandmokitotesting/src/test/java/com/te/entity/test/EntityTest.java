package com.te.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.dao.EmpDao;
import com.te.dto.EmpDto;
import com.te.dto.LoginDto;
import com.te.dto.ResponseDto;
import com.te.entity.Employee;
import com.te.service.EmpService;

public class EntityTest {

	
	@Test
	public void serializeTestForEmployee() throws JsonMappingException, JsonProcessingException {
		String json= "{\"empId\":\"tyc001\",\"empPwd\":\"12345\",\"empName\":\"sushma\",\"empMail\":\"sush@gmail.com\"}";
		ObjectMapper objectMapper=new ObjectMapper();
		Employee employee=objectMapper.readValue(json, Employee.class);
		System.err.println(employee);
		String writeValueAsString = objectMapper.writeValueAsString(employee);
		System.err.println(writeValueAsString);
		assertEquals(writeValueAsString, json);
	}
	
	
	
	@Test
	public void deserializeTestForEmployee() throws JsonMappingException, JsonProcessingException {
		String json= "{\"empId\":\"tyc001\",\"empPwd\":\"12345\",\"empName\":\"sushma\",\"empMail\":\"sush@gmail.com\"}";
		ObjectMapper objectMapper=new ObjectMapper();
		Employee employee=objectMapper.readValue(json, Employee.class);
		System.err.println(employee);
		assertEquals("tyc001", employee.getEmpId());
	}
	
	
	
	@Test
	public void serializeTestForEmpDto() throws JsonMappingException, JsonProcessingException {
		String json= "{\"empId\":\"tyc001\",\"empPwd\":\"12345\",\"empName\":\"sushma\",\"empMail\":\"sush@gmail.com\"}";
		ObjectMapper objectMapper=new ObjectMapper();
		EmpDto emp=objectMapper.readValue(json, EmpDto.class);
		String writeValueAsString = objectMapper.writeValueAsString(emp);
		assertEquals(writeValueAsString, json);
	}
	
	@Test
	public void deserializeTestForEmpDto() throws JsonMappingException, JsonProcessingException {
		String json= "{\"empId\":\"tyc001\",\"empPwd\":\"12345\",\"empName\":\"sushma\",\"empMail\":\"sush@gmail.com\"}";
		ObjectMapper objectMapper=new ObjectMapper();
		EmpDto emp=objectMapper.readValue(json, EmpDto.class);
		assertEquals("tyc001", emp.getEmpId());
	}
	
	@Test
	public void serializeTestForLoginDto() throws JsonMappingException, JsonProcessingException {
		String json= "{\"empId\":\"tyc001\",\"empPwd\":\"12345\"}";
		ObjectMapper objectMapper=new ObjectMapper();
		LoginDto employee=objectMapper.readValue(json, LoginDto.class);
		String writeValueAsString = objectMapper.writeValueAsString(employee);
		assertEquals(writeValueAsString, json);
	}
	
	@Test
	public void deserializeTestForLoginDto() throws JsonMappingException, JsonProcessingException {
		String json= "{\"empId\":\"tyc001\",\"empPwd\":\"12345\"}";
		ObjectMapper objectMapper=new ObjectMapper();
		LoginDto employee=objectMapper.readValue(json, LoginDto.class);
		assertEquals("tyc001", employee.getEmpId());
	}
	
	@Test
	public void serializeTestForResponseDto() throws JsonMappingException, JsonProcessingException {
		String json= "{\"status\":true,\"msg\":\"success\",\"object\":null}";
		ObjectMapper objectMapper=new ObjectMapper();
		ResponseDto employee=objectMapper.readValue(json, ResponseDto.class);
		String writeValueAsString = objectMapper.writeValueAsString(employee);
		assertEquals(writeValueAsString, json);
	}
	
	@Test
	public void deserializeTestForResponseDto() throws JsonMappingException, JsonProcessingException {
		String json= "{\"status\":true,\"msg\":\"success\",\"object\":null}";
		ObjectMapper objectMapper=new ObjectMapper();
		ResponseDto employee=objectMapper.readValue(json, ResponseDto.class);
		assertEquals(true, employee.getStatus());
	}
}
