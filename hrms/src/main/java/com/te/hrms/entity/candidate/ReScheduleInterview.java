package com.te.hrms.entity.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reschedule_interview_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReScheduleInterview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int key;
	private String email;
	private String link;
	private String address;
	private String interviewDate;
	private String startTime;
	private double duration;
	private String interviewerDetails;
	private String reasonForReSchedule;

}
