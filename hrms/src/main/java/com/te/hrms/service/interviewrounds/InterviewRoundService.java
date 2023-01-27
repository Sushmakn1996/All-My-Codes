package com.te.hrms.service.interviewrounds;

import com.te.hrms.dto.interviewrounds.InterviewRoundRequest;
import com.te.hrms.entity.interviewrounds.InterviewRounds;

public interface InterviewRoundService {
	
	InterviewRounds addInterviewRound(InterviewRoundRequest request);
	
//	InterviewRounds editInterviewRound(InterviewRoundRequest request);
	
	boolean deleteInterviewRound(int roundNumber);
	
	

}
