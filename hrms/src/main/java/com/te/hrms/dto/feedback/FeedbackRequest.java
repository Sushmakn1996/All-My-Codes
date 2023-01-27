package com.te.hrms.dto.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRequest {
	
	private String key;
	private String feedbackFactorType;
	private String feedbackFactor;

	
	

}
