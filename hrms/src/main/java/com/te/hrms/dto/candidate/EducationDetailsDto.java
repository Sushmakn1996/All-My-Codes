package com.te.hrms.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDetailsDto {
	
	private int educationId;
	private String highestDegree;
	private String course;
	private String instituteName;
	private String averageGrade;
	private String resumeUrl;

}
