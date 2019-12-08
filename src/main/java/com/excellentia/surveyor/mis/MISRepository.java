package com.excellentia.surveyor.mis;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.excellentia.surveyor.insurer.Insurer;

public interface MISRepository extends CrudRepository<MIS, Long> {
	
	@Override
	Iterable<MIS> findAll();
	
	@Override
	Optional<MIS> findById(Long id);
	
	@Query("Select u from MIS u where u.jobNo = ?1")
	List<MIS> getListOnJobNo(String jobno);
	
	@Query("Select u from MIS u where u.jobNo like ?1% order by u.jobNo asc")
	List<MIS> getLastJobNo(String jobno);
	
	
	@Query("Select u from MIS u where u.fieldStaff = ?1")
	List<MIS> getListOnFieldStaff(Long urid);
	
}