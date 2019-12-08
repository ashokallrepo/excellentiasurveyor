package com.excellentia.surveyor.fieldstaff;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.job_status.JobStatus;

public interface FieldStaffRepository extends CrudRepository<FieldStaff, Long> {
	
	@Override
	List<FieldStaff> findAll();	
	
	@Override
	Optional<FieldStaff> findById(Long id);
	
	
	@Query("Select u from FieldStaff u where u.name = ?1")
	List<FieldStaff> getListOnName(String name);
	
	@Query("Select u from FieldStaff u where u.userId = ?1")
	FieldStaff findByUserId(Long id);
	
	
	
	
}