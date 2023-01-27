package com.te.newtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequsetDto {
	
	private int empId;
	private String name;
	private int age;
	private double sal;


}
