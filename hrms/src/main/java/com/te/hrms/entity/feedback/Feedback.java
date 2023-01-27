package com.te.hrms.entity.feedback;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "feedbacks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	@Id
	private String key;
	private String feedbackFactorType;
	private String feedbackFactor;
	
	
		
	
	

}
