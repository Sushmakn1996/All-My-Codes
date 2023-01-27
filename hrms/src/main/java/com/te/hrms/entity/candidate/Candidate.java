package com.te.hrms.entity.candidate;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidate_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateId;
	private String firstName;
	private String lastName;
	private String emailId;
	private long mobileNumber;
	private int departmentNo;
	private String designation;
	private String employmentStatus;
	private double yearOfExperience;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "candidate")
	@JsonManagedReference
	private ReferencePerson referencePerson;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "candidate")
	@JsonManagedReference
	private List<EducationDetails> educationDetails;

}
