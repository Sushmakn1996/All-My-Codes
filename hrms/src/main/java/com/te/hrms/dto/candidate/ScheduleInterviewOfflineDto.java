package com.te.hrms.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleInterviewOfflineDto {
	
	private String address;
	private String email;
	private String interviewDate;
	private String startTime;
	private double duration;
	private String interviewerDetails;

}
