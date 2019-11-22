package com.excellentia.surveyor.sub_dept;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.department.Department;
import com.excellentia.surveyor.login.LoginTrack;

public interface SubDepartmentRepository extends CrudRepository<SubDepartment, Long> {
	
	@Override
	Iterable<SubDepartment> findAll();	
	
	@Override
	Optional<SubDepartment> findById(Long id);
	
	@Query("Select u from SubDepartment u where u.name = ?1 and u.department = ?2")
	List<SubDepartment> getListOnName(String name, Long dept);
	
	
}