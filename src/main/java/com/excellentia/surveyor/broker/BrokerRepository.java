package com.excellentia.surveyor.broker;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.registration_branch.RegistrationBranch;

public interface BrokerRepository  extends CrudRepository<Broker, Long> {
	
	@Override
	Iterable<Broker> findAll();
	
	
	@Override
	Optional<Broker> findById(Long id);
	
	@Query("Select u from Broker u where u.name = ?1")
	List<Broker> getListOnName(String name);
	
}