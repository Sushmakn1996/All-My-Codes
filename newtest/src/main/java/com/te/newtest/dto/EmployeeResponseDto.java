package com.te.newtest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponseDto {

	private boolean value;
	private String message;
	private Object object;

}
