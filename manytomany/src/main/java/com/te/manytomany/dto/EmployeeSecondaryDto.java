package com.te.manytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSecondaryDto {
	
	private String panNum;
	private String aadharNum;
	private String designation;
	private String department;

}
