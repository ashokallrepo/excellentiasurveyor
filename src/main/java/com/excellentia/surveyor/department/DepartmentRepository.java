package com.excellentia.surveyor.department;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
	@Override
	Iterable<Department> findAll();	
	
	@Override
	Optional<Department> findById(Long id);
	
	@Query("Select u from Department u where u.name = ?1")
	List<Department> getListOnName(String name);

	
	@Query("Select u from Department u where u.id in (?1)")
	List<Department> getListOnMultipleIds(List<Long> ids);
}