package com.excellentia.surveyor.estimated_claim_amt;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.registration_branch.RegistrationBranch;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

public interface EstimatedClaimAmtRepository extends CrudRepository<EstimatedClaimAmt, Long> {
	
	@Override
	Iterable<EstimatedClaimAmt> findAll();	
	
	@Override
	Optional<EstimatedClaimAmt> findById(Long id);
	
	@Query("Select u from EstimatedClaimAmt u where u.value = ?1")
	List<EstimatedClaimAmt> getListOnValue(String value);
	
	@Query("Select u from EstimatedClaimAmt u where u.id in (?1)")
	List<EstimatedClaimAmt> getListOnMultipleIds(List<Long> ids);
	
	
}