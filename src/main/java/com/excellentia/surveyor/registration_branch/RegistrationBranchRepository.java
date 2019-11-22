package com.excellentia.surveyor.registration_branch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.sub_dept.SubDepartment;

public interface RegistrationBranchRepository extends CrudRepository<RegistrationBranch, Long> {
	
	@Override
	Iterable<RegistrationBranch> findAll();	
	
	@Override
	Optional<RegistrationBranch> findById(Long id);
	
	@Query("Select u from RegistrationBranch u where u.name = ?1")
	List<RegistrationBranch> getListOnName(String name);
	
	
}