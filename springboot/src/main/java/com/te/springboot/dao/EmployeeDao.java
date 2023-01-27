package com.te.springboot.dao;

import com.te.springboot.entity.Employee;
import com.te.springboot.entity.LoginDetails;

public interface EmployeeDao {
	
	public Employee register(Employee employee);
	
	public Employee login(LoginDetails details);
	

}
