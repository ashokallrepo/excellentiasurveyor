package com.excellentia.surveyor.insurer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.registration_branch.RegistrationBranch;

public interface InsurerRepository extends CrudRepository<Insurer, Long> {
	
	@Override
	Iterable<Insurer> findAll();	
	
	@Override
	Optional<Insurer> findById(Long id);
	
	
	@Query("Select u from Insurer u where u.name = ?1 and u.type = ?2 and u.state = ?3")
	List<Insurer> getListOnName(String name, String type, String state);
	
	
}