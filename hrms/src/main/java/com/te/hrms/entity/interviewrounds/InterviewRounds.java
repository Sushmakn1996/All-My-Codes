package com.te.hrms.entity.interviewrounds;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "interviewrounds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewRounds {
	
	@Id
	private int roundNumber;
	private String roundName;
	
	

}
