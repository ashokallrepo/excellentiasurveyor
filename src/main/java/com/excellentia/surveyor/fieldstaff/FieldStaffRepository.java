package com.excellentia.surveyor.fieldstaff;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.registration_branch.RegistrationBranch;

public interface FieldStaffRepository extends CrudRepository<FieldStaff, Long> {
	
	@Override
	Iterable<FieldStaff> findAll();	
	
	@Override
	Optional<FieldStaff> findById(Long id);
	
	
	@Query("Select u from FieldStaff u where u.name = ?1")
	List<FieldStaff> getListOnName(String name);
	
	
}