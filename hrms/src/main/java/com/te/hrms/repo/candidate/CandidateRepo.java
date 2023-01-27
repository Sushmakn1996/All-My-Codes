package com.te.hrms.repo.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.hrms.entity.candidate.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
	
//	Candidate findByName(String firstName);

}
