package com.te.hrms.service.interviewrounds;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.hrms.dto.interviewrounds.InterviewRoundRequest;
import com.te.hrms.entity.interviewrounds.InterviewRounds;
import com.te.hrms.repo.interviewrounds.InterviewRoundRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InterviewRoundServiceImpl implements InterviewRoundService {
	
	@Autowired
	private InterviewRoundRepo interviewRoundRepo;

	InterviewRounds interviewRounds = null;
	
	@Override
	public InterviewRounds addInterviewRound(InterviewRoundRequest request) {
		Optional<InterviewRounds> findById = interviewRoundRepo.findById(request.getRoundNumber());
		if (findById.isPresent()) {
			log.info("inside editinterview service");
			BeanUtils.copyProperties(request, findById.get());
			return interviewRoundRepo.save(findById.get());// edit
		} else {
			log.info("inside addinterview service");
			InterviewRounds interviewRounds = new InterviewRounds();
			BeanUtils.copyProperties(request, interviewRounds);
			return interviewRoundRepo.save(interviewRounds);// save
		}
	}

	@Override
	public boolean deleteInterviewRound(int roundNumber) {
		log.info("inside deleteinterview service");
		Optional<InterviewRounds> findById = interviewRoundRepo.findById(roundNumber);
		boolean present = findById.isPresent();
		if (present) {
			interviewRoundRepo.deleteById(roundNumber);
			return true;
		}
		return false;
	}
	
	
	
//	@Override
//	public InterviewRounds editInterviewRound(InterviewRoundRequest request) {
//		Optional<InterviewRounds> findById = interviewRoundRepo.findById(request.getRoundNumber());
//		boolean present = findById.isPresent();
//		if (present) {
//			interviewRounds = modelMapper.map(request, InterviewRounds.class);
//			return interviewRoundRepo.save(interviewRounds);
//		}
//		return null;
//		boolean present = findById.isPresent();
//		interviewRounds = modelMapper.map(request, InterviewRounds.class);
//	}


}
