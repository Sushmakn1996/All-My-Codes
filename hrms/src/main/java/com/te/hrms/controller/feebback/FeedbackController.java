package com.te.hrms.controller.feebback;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.hrms.dto.feedback.FeedbackRequest;
import com.te.hrms.dto.feedback.FeedbackResponse;
import com.te.hrms.service.feedback.FeedbackService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/addfeedback")
	public ResponseEntity<FeedbackResponse> addFeedback(@RequestBody FeedbackRequest request) {
		log.info("inside addfeedback controller");
		if (request != null) {
			return new ResponseEntity<>(
					new FeedbackResponse(false, "Feedback Added", feedbackService.addFeedback(request)),
					HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new FeedbackResponse(true, "Failed to Add", request), HttpStatus.BAD_GATEWAY);
		}
	}

	@PostMapping("/editfeedback")
	public ResponseEntity<FeedbackResponse> editFeedback(@RequestBody FeedbackRequest request) {
		log.info("inside editfeedback controller");
		if (request.getFeedbackFactorType() != null) {
			return new ResponseEntity<>(
					new FeedbackResponse(false, "Feedback Edited successfully", feedbackService.editFeedback(request)),
					HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new FeedbackResponse(true, "Failed to edit the record", request),
					HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("/deletefeedback")
	public ResponseEntity<FeedbackResponse> deleteFeedback(String feedbackFactorType) {
		log.info("inside deletefeedback controller");
		if (feedbackFactorType!=null) {
			return new ResponseEntity<>(new FeedbackResponse(false, "Deleted successfully",
					feedbackService.deleteFeedback(feedbackFactorType)), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new FeedbackResponse(true, "Deletion Failed", feedbackFactorType),
					HttpStatus.BAD_REQUEST);
		}
	}
}
