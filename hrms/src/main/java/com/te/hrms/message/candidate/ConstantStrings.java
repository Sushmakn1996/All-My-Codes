package com.te.hrms.message.candidate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantStrings {

	public static final String CANDIDATE_ADD = "Candidate Added Successfully";
	public static final String CANDIDATE_ADD_FAIL="Candidate Failed to Add";
	public static final String CANDIDATE_EDIT="Candidate Edited Successfully";
	public static final String CANDIDATE_EDIT_FAIL="Candidate Failed to Edit";
	public static final String CANDIDATE_DELETE="Candidate Deleted Successfully";
	public static final String CANDIDATE_DELETE_FAIL="Candidate Not Found";
	
	public static final String SCHEDULE_OFFLINE="Interview Scheduled Successfully";
	public static final String SCHEDULE_ONLINE="Interview Mail Sent Successfully";
	public static final String RE_SCHEDULE_OFFLINE="Interview ReScheduled Successfully";
	public static final String RE_SCHEDULE_ONLINE="Interview ReScheduled Mail Sent Successfully";
}
