package com.excellentia.surveyor.job_status;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.fieldstaff.FieldStaff;

public interface JobStatusRepository extends CrudRepository<JobStatus, Long> {
	
	@Override
	Iterable<JobStatus> findAll();	
	
	@Override
	Optional<JobStatus> findById(Long id);
	
	@Query("Select u from JobStatus u where u.id in (?1)")
	List<JobStatus> getListOnMultipleIds(List<Long> ids);
	
	
	@Query("Select u from JobStatus u where u.status = ?1")
	List<JobStatus> findByStatusName(String name);
	

}
