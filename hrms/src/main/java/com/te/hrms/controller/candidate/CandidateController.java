package com.te.hrms.controller.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.dto.candidate.CandidateRequestDto;
import com.te.hrms.dto.candidate.CandidateResponseDto;
import com.te.hrms.dto.candidate.ReScheduleInterviewOfflineDto;
import com.te.hrms.dto.candidate.ReScheduleInterviewOnlineDto;
import com.te.hrms.dto.candidate.ScheduleInterviewOfflineDto;
import com.te.hrms.dto.candidate.ScheduleInterviewOnlineDto;
import com.te.hrms.entity.candidate.Candidate;
import com.te.hrms.message.candidate.ConstantStrings;
import com.te.hrms.service.candidate.CandidateService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@PostMapping("/addCandidate")
	public ResponseEntity<CandidateResponseDto> addCandidate(@RequestBody CandidateRequestDto request) {
		log.info("inside addcandidate controller");
		if (request != null) {
			return new ResponseEntity<>(new CandidateResponseDto(false, ConstantStrings.CANDIDATE_ADD,
					candidateService.addCandidate(request)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new CandidateResponseDto(true, ConstantStrings.CANDIDATE_ADD_FAIL, request),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Candidate> getCandidateById(int candidateId){
		log.info("inside getcandidate controller");
		if (candidateId >= 0) {
			candidateService.getCandidateById(candidateId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/editCandidate")
	public ResponseEntity<CandidateResponseDto> editCandidate(@RequestBody CandidateRequestDto request) {
		log.info("inside editcandidate controller");
		if (request.getCandidateId() >= 0) {
			return new ResponseEntity<>(new CandidateResponseDto(false, ConstantStrings.CANDIDATE_EDIT,
					candidateService.editCandidate(request)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new CandidateResponseDto(true, ConstantStrings.CANDIDATE_EDIT_FAIL, request),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteCandidate")
	public ResponseEntity<CandidateResponseDto> deleteCandidate(int candidateId) {
		log.info("inside deletecandidate controller");
		if (candidateId >= 0) {
			return new ResponseEntity<>(new CandidateResponseDto(false, ConstantStrings.CANDIDATE_DELETE,
					candidateService.deleteCandidate(candidateId)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(
					new CandidateResponseDto(true, ConstantStrings.CANDIDATE_DELETE_FAIL, candidateId),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/scheduleInterviewOffline")
	public String scheduleInterviewOffline(@RequestBody ScheduleInterviewOfflineDto offline) {
		return candidateService.scheduleInterviewOffline(offline);
	}

	@PostMapping("/scheduleInterviewOnline")
	public String scheduleInterviewOnline(@RequestBody ScheduleInterviewOnlineDto online) {
		return candidateService.scheduleInterviewOnline(online);
	}

	@PostMapping("/reScheduleInterviewOffline")
	public String reScheduleInterviewOffline(@RequestBody ReScheduleInterviewOfflineDto offline) {
		return candidateService.reScheduleInterviewOffline(offline);
	}

	@PostMapping("/reScheduleInterviewOnline")
	public String reScheduleInterviewOnline(@RequestBody ReScheduleInterviewOnlineDto online) {
		return candidateService.reScheduleInterviewOnline(online);
	}

}
