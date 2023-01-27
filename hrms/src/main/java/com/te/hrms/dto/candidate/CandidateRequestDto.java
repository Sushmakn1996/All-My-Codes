package com.te.hrms.dto.candidate;

import java.util.List;

import com.te.hrms.entity.candidate.EducationDetails;
import com.te.hrms.entity.candidate.ReferencePerson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRequestDto {

	private int candidateId;
	private String firstName;
	private String lastName;
	private String emailId;
	private long mobileNumber;
	private int departmentNo;
	private String designation;
	private String employmentStatus;
	private double yearOfExperience;

	private ReferencePerson referencePerson;

	private List<EducationDetails> educationDetails;

	public CandidateRequestDto(int candidateId) {
		this.candidateId = candidateId;
	}
	
	

}
