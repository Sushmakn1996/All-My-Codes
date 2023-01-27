package com.te.hrms.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleInterviewOnlineDto {
	
	private String link;
	private String email;
	private String interviewDate;
	private String startTime;
	private double duration;
	private String interviewerDetails;

	

}
