package com.te.hrms.dto.candidate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReScheduleInterviewOnlineDto {
	
	private String link;
	private String email;
	private String interviewDate;
	private String startTime;
	private double duration;
	private String interviewerDetails;
	private String reasonForReSchedule;
	
	
	public ReScheduleInterviewOnlineDto(String link, String email, String interviewDate, String startTime,
			double duration, String interviewerDetails, String reasonForReSchedule) {
		super();
		this.link = link;
		this.email = email;
		this.interviewDate = interviewDate;
		this.startTime = startTime;
		this.duration = duration;
		this.interviewerDetails = interviewerDetails;
		this.reasonForReSchedule = reasonForReSchedule;
	}
	
	

}
