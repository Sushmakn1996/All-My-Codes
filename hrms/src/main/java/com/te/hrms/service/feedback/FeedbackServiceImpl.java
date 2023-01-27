package com.te.hrms.service.feedback;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.hrms.dto.feedback.FeedbackRequest;
import com.te.hrms.entity.feedback.Feedback;
import com.te.hrms.repo.feedback.FeedbackRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepo feedbackRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Feedback addFeedback(FeedbackRequest request) {
		log.info("inside addfeedback service");
		Feedback map = modelMapper.map(request, Feedback.class);
		return feedbackRepo.save(map);
	}

	@Override
	public Feedback editFeedback(FeedbackRequest request) {
		log.info("inside editfeedback service");
		Feedback findByFeedbackFactorType = feedbackRepo.findByFeedbackFactorType(request.getFeedbackFactorType());
		if(findByFeedbackFactorType.getFeedbackFactorType().equalsIgnoreCase(request.getFeedbackFactorType())) {
			Feedback map = modelMapper.map(request, Feedback.class);
			return feedbackRepo.save(map);
		}
		return findByFeedbackFactorType;
	}

	@Override
	public boolean deleteFeedback(String feedbackFactorType) {
		log.info("inside deletefeedback service");
		 Feedback findByFeedbackFactorType = feedbackRepo.findByFeedbackFactorType(feedbackFactorType);
			if (findByFeedbackFactorType.getFeedbackFactorType().equalsIgnoreCase(feedbackFactorType)) {
				feedbackRepo.deleteById(feedbackFactorType);
				return true;
			}
			return false;
		}
	}
