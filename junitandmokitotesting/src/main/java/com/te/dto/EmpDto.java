package com.te.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDto {
	
	@NotEmpty
	private String empId;
	@NotEmpty
	@Size(min = 3,max = 10,message = "password must be minimum of 3 and maximum of 10")
	private String empPwd;
	@NotEmpty
	private String empName;
	@NotEmpty
	@Email(message = "email address not valid")
	private String empMail;
	
	

}