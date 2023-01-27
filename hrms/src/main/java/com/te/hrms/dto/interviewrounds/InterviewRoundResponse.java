package com.te.hrms.dto.interviewrounds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewRoundResponse {
	
	private boolean error;
	private String message;
	private Object object;

}
