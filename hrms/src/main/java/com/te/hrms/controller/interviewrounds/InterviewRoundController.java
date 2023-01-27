package com.te.hrms.controller.interviewrounds;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.dto.interviewrounds.InterviewRoundRequest;
import com.te.hrms.dto.interviewrounds.InterviewRoundResponse;
import com.te.hrms.service.interviewrounds.InterviewRoundService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InterviewRoundController {

	@Autowired
	private InterviewRoundService interviewRoundService;

	@PostMapping("/addround")
	public ResponseEntity<InterviewRoundResponse> addInterviewRound(@RequestBody InterviewRoundRequest request) {
		log.info("inside addinterview controller");
		if (request != null) {
			return new ResponseEntity<>(new InterviewRoundResponse(false, "Round added successfully",
					interviewRoundService.addInterviewRound(request)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new InterviewRoundResponse(true, " Adding round Unsuccessful", request),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/editround")
	public ResponseEntity<InterviewRoundResponse> editInterviewRound(@RequestBody InterviewRoundRequest request) {
		log.info("inside editinterview controller");
		if (request != null) {
			return new ResponseEntity<>(new InterviewRoundResponse(false, "Round edited successfully",
					interviewRoundService.addInterviewRound(request)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new InterviewRoundResponse(true, "Edit Unsuccessful", request),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteround")
	public ResponseEntity<InterviewRoundResponse> deleteInterviewRoundByNumber(int roundNumber) {
		log.info("inside deleteinterview controller");
		if (roundNumber>=0) {
			return new ResponseEntity<>(new InterviewRoundResponse(false, "Deleted successfully",
					interviewRoundService.deleteInterviewRound(roundNumber)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new InterviewRoundResponse(true, "Deletion Failed", roundNumber),
					HttpStatus.BAD_REQUEST);
		}
	}
}
