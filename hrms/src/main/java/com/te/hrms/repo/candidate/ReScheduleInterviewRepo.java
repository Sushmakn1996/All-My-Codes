package com.te.hrms.repo.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.hrms.entity.candidate.ReScheduleInterview;

@Repository
public interface ReScheduleInterviewRepo extends JpaRepository<ReScheduleInterview, Integer> {

}
