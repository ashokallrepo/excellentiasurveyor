package com.excellentia.surveyor.surveyor_db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SurveyorRepository extends CrudRepository<Surveyor, Long> {
	
	@Override
	Iterable<Surveyor> findAll();	
	
	@Override
	Optional<Surveyor> findById(Long id);
	
	
	@Query("Select u from Insurer u where u.name = ?1")
	List<Surveyor> getListOnName(String name);
	
	
}