package com.excellentia.surveyor.insured;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.estimated_claim_amt.EstimatedClaimAmt;
import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

public interface InsuredRepository extends CrudRepository<Insured, Long> {
	
	@Override
	Iterable<Insured> findAll();	
	
	@Override
	Optional<Insured> findById(Long id);
	
	@Query("Select u from Insured u where u.name = ?1")
	List<Insured> getListOnValue(String name);
	
	@Query("Select u from Insured u where u.id in (?1)")
	List<Insured> getListOnMultipleIds(List<Long> ids);
	

	
	
}