package com.te.springboot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.dao.EmployeeDao;
import com.te.springboot.dto.EmployeeRequestDto;
import com.te.springboot.dto.LoginRequestDto;
import com.te.springboot.entity.Employee;
import com.te.springboot.entity.LoginDetails;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee register(EmployeeRequestDto employeeRequestDto) {
		Employee employee=new Employee();
		if(employeeRequestDto.getEmpId().startsWith("TYSS")) {
		BeanUtils.copyProperties(employeeRequestDto, employee);
	}
		return employeeDao.register(employee);
	}

	@Override
	public Employee login(LoginRequestDto loginRequestDto) {
		LoginDetails loginDetails=new LoginDetails();
		BeanUtils.copyProperties(loginRequestDto, loginDetails);
		return employeeDao.login(loginDetails);
	}

}
