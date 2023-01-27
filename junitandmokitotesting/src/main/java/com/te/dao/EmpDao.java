package com.te.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.dto.EmpDto;
import com.te.entity.Employee;

public interface EmpDao extends CrudRepository<Employee, String> {
	
	public Employee findByEmpId(String empId);

	public String save(EmpDto dto);

	public String findById(Employee emp);

}
