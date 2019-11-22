package com.excellentia.surveyor.source_of_instruction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SourceOfInsturctionRepository extends CrudRepository<SourceOfInstruction, Long> {
	
	@Override
	Iterable<SourceOfInstruction> findAll();
	
	@Override
	Optional<SourceOfInstruction> findById(Long id);
	
	@Query("Select u from SourceOfInstruction u where u.name = ?1 and u.insurer = ?2")
	List<SourceOfInstruction> getListOnNameAndInsurer(String name, Long insurer);

	
	@Query("Select u from SourceOfInstruction u where u.id in (?1)")
	List<SourceOfInstruction> getListOnMultipleIds(List<Long> ids);
}