package com.excellentia.surveyor.job_status;

import java.util.List;
import java.util.Map;

import com.excellentia.surveyor.estimated_claim_amt.EstimatedClaimAmt;

public interface IJobStatusService {

	List<JobStatus> getJobStatus();
	List<JobStatus> getJobStatusBasedOnRole(String role);
	JobStatus findById(Long id);
	JobStatus findByStatusName(String name);
	
	Map<Long,JobStatus> getRecordsInMap(List<JobStatus> li);
	Map<Long, JobStatus> getListOnMultipleIds(List<Long> ids);

	
}
