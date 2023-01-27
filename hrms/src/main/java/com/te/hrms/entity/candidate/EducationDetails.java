package com.te.hrms.entity.candidate;

import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="education_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	private String highestDegree;
	private String course;
	private String instituteName;
	private String averageGrade;
	private String resumeUrl;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Candidate candidate;

}
