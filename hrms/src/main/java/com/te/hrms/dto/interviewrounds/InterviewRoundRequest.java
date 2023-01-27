package com.te.hrms.dto.interviewrounds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewRoundRequest {
	
	private int roundNumber;
	private String roundName;
	

}
