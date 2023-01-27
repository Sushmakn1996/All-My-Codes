package com.te.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
	
	private String empId;
	private String userName;
	private String password;
	private String firstName;
	private String laastName;
	private String mobNo;

}
