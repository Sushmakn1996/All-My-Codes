package com.te.springboot.service;

import com.te.springboot.dto.EmployeeRequestDto;
import com.te.springboot.dto.LoginRequestDto;
import com.te.springboot.entity.Employee;

public interface EmployeeService {
	
	public Employee register(EmployeeRequestDto employeeRequestDto);
	
	public Employee login(LoginRequestDto loginRequestDto);

}
