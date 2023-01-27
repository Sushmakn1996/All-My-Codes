package com.te.hrms.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResponseDto {
	
	private boolean error;
	private String message;
	private Object object;

}
