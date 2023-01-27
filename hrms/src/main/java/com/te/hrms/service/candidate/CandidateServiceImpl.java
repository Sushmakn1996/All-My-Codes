package com.te.hrms.service.candidate;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.te.hrms.dto.candidate.CandidateRequestDto;
import com.te.hrms.dto.candidate.ReScheduleInterviewOfflineDto;
import com.te.hrms.dto.candidate.ReScheduleInterviewOnlineDto;
import com.te.hrms.dto.candidate.ScheduleInterviewOfflineDto;
import com.te.hrms.dto.candidate.ScheduleInterviewOnlineDto;
import com.te.hrms.entity.candidate.Candidate;
import com.te.hrms.entity.candidate.EducationDetails;
import com.te.hrms.entity.candidate.ReScheduleInterview;
import com.te.hrms.entity.candidate.ScheduleInterview;
import com.te.hrms.message.candidate.ConstantStrings;
import com.te.hrms.repo.candidate.CandidateRepo;
import com.te.hrms.repo.candidate.ReScheduleInterviewRepo;
import com.te.hrms.repo.candidate.ScheduleInterviewRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepo candidateRepo;

	@Autowired
	private ScheduleInterviewRepo scheduleInterviewRepo;

	@Autowired
	private ReScheduleInterviewRepo reScheduleInterviewRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Candidate addCandidate(CandidateRequestDto request) {
		log.info("inside addcandidate service");
		Candidate map = mapper.map(request, Candidate.class);
		map.getReferencePerson().setCandidate(map);
		for (EducationDetails details : map.getEducationDetails()) {
			details.setCandidate(map);
		}
		return candidateRepo.save(map);
	}

	@Override
	public Candidate getCandidateById(int candidateId) {
		log.info("inside getcandidate service");
		Optional<Candidate> findById = candidateRepo.findById(candidateId);
		return findById.get();
		 
	}

	@Override
	public Candidate editCandidate(CandidateRequestDto request) {
		log.info("inside editcandidate service");
		Optional<Candidate> findById = candidateRepo.findById(request.getCandidateId());
		boolean present = findById.isPresent();
		if (present) {
			Candidate map = mapper.map(request, Candidate.class);
			map.getReferencePerson().setCandidate(map);
			for (EducationDetails details : map.getEducationDetails()) {
				details.setCandidate(map);
			}
			return candidateRepo.save(map);
		}
		return null;
	}

	@Override
	public boolean deleteCandidate(int candidateId) {
		log.info("inside deletecandidate service");
		Optional<Candidate> findById = candidateRepo.findById(candidateId);
		Candidate candidate = findById.get();
		if (candidate.getCandidateId() == candidateId) {
			candidateRepo.delete(candidate);
			return true;
		}
		return false;
	}

	@Override
	public String scheduleInterviewOffline(ScheduleInterviewOfflineDto offline) {
		ScheduleInterview map = mapper.map(offline, ScheduleInterview.class);
		scheduleInterviewRepo.save(map);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sushmanayaka66@gmail.com");
		message.setTo(offline.getEmail());
		message.setText("Dear Candidate..." + "\n" + " Your interview is Scheduled on " + offline.getInterviewDate()
				+ " at " + offline.getStartTime() + ".\n" + " Your interview is at " + offline.getAddress() + ".\n"
				+ "Your interviewer will be " + offline.getInterviewerDetails() + ".\n"
				+ "All the best for your interview..." + "\n" + "Thanks and regards" + "\n" + "Sushma");
		message.setSubject("Your interview Details");
		javaMailSender.send(message);
		return ConstantStrings.SCHEDULE_OFFLINE;
	}

	@Override
	public String scheduleInterviewOnline(ScheduleInterviewOnlineDto online) {
		ScheduleInterview map = mapper.map(online, ScheduleInterview.class);
		scheduleInterviewRepo.save(map);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sushmanayaka66@gmail.com");
		message.setTo(online.getEmail());
		message.setText("Dear Candidate..." + "\n" + " Your interview is Scheduled on " + online.getInterviewDate()
				+ " at " + online.getStartTime() + ".\n" + " Your interview link is attached below " + online.getLink()
				+ ".\n" + "Your interviewer will be " + online.getInterviewerDetails() + ".\n"
				+ "All the best for your interview..." + "\n" + "Thanks and regards" + "\n" + "Sushma");
		message.setSubject("Your interview Details");
		javaMailSender.send(message);
		return ConstantStrings.SCHEDULE_ONLINE;
	}

	@Override
	public String reScheduleInterviewOffline(ReScheduleInterviewOfflineDto offline) {
		ReScheduleInterview map = mapper.map(offline, ReScheduleInterview.class);
		reScheduleInterviewRepo.save(map);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sushmanayaka66@gmail.com");
		message.setTo(offline.getEmail());
		message.setText("Dear Candidate..." + "\n" + " Your interview is reScheduled on " + offline.getInterviewDate()
				+ " at " + offline.getStartTime() + ".\n" + " Your interview is at " + offline.getAddress() + ".\n"
				+ "Your interviewer will be " + offline.getInterviewerDetails() + ".\n"
				+ "All the best for your interview..." + "\n" + "Thanks and regards" + "\n" + "Sushma");
		message.setSubject("Your interview Details");
		javaMailSender.send(message);
		return ConstantStrings.RE_SCHEDULE_OFFLINE;
	}

	@Override
	public String reScheduleInterviewOnline(ReScheduleInterviewOnlineDto online) {
		ReScheduleInterview map = mapper.map(online, ReScheduleInterview.class);
		reScheduleInterviewRepo.save(map);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sushmanayaka66@gmail.com");
		message.setTo(online.getEmail());
		message.setText("Dear Candidate..." + "\n" + " Your interview is reScheduled on " + online.getInterviewDate()
				+ " at " + online.getStartTime() + ".\n" + " Your interview link is attached below " + online.getLink()
				+ ".\n" + "Your interviewer will be " + online.getInterviewerDetails() + ".\n"
				+ "All the best for your interview..." + "\n" + "Thanks and regards" + "\n" + "Sushma");
		message.setSubject("Your interview Details");
		javaMailSender.send(message);
		return ConstantStrings.RE_SCHEDULE_ONLINE;
	}

}
