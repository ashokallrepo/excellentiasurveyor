package com.excellentia.surveyor.login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.job_status.JobStatus;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	
	@Override
	Optional<Role> findById(Long id);
	
	
	@Query("Select u from Role u where u.name = ?1")
	Role getRoleByName(String name);
	
	@Override
	List<Role> findAll();	
	
	
	
}
