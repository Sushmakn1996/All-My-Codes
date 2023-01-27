package com.te.hrms.service.candidate;

import com.te.hrms.dto.candidate.CandidateRequestDto;
import com.te.hrms.dto.candidate.ReScheduleInterviewOfflineDto;
import com.te.hrms.dto.candidate.ReScheduleInterviewOnlineDto;
import com.te.hrms.dto.candidate.ScheduleInterviewOfflineDto;
import com.te.hrms.dto.candidate.ScheduleInterviewOnlineDto;
import com.te.hrms.entity.candidate.Candidate;

public interface CandidateService {
	
	Candidate addCandidate(CandidateRequestDto request);
	
	Candidate getCandidateById(int candidateId);
	
	Candidate editCandidate(CandidateRequestDto request);
	
	boolean deleteCandidate(int candidateId);
	
	String scheduleInterviewOffline(ScheduleInterviewOfflineDto offline);
	
	String scheduleInterviewOnline(ScheduleInterviewOnlineDto online);
	
	String reScheduleInterviewOffline(ReScheduleInterviewOfflineDto offline);
	
	String reScheduleInterviewOnline(ReScheduleInterviewOnlineDto online);

}
