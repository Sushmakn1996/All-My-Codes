package com.te.manytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseDto {
	
	private boolean value;
	private String msg;
	private Object obj;

}
