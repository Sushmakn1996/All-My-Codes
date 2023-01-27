package com.te.hrms.repo.feedback;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.hrms.entity.feedback.Feedback;

@Repository
public interface FeedbackRepo extends MongoRepository<Feedback, String> {
	
	Feedback findByFeedbackFactorType(String feedback);

}
