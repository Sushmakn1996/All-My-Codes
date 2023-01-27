package com.te.hrms.repo.interviewrounds;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.hrms.entity.interviewrounds.InterviewRounds;

@Repository
public interface InterviewRoundRepo extends MongoRepository<InterviewRounds, Integer> {
	
	public List<InterviewRounds> findByRoundName(String request);

}
