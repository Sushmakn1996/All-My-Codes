package com.te.manytomany.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDto {
	
	private int empId;
	private String empName;
	private int age;
	private double salary;
	
	private EmployeeSecondaryDto employeeSecondaryDto;

	private List<EmployeeTechnicalSkillsDto> employeeTechnicalSkillsDtos;

}
