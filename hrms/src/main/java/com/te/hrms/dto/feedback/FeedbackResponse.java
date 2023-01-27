package com.te.hrms.dto.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse {
	
	private boolean error;
	private String message;
	private Object object;

}
