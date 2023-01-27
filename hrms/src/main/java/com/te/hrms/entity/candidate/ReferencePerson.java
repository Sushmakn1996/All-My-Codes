package com.te.hrms.entity.candidate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reference_person_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferencePerson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int referenceId;
	private String employeeId;
	private String employeeName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Candidate candidate;

}
