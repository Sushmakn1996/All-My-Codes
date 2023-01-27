package com.te.hrms.service.feedback;

import com.te.hrms.dto.feedback.FeedbackRequest;
import com.te.hrms.entity.feedback.Feedback;

public interface FeedbackService {

	Feedback addFeedback(FeedbackRequest request);
	
	Feedback editFeedback(FeedbackRequest request);
	
	boolean deleteFeedback(String feedbackFactorType);

}
