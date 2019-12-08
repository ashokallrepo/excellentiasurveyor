package com.excellentia.surveyor.login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("FROM User WHERE userName=:username")
	User findByUsername(@Param("username")String username);
	
	@Override
	Optional<User> findById(Long id);
	

	@Override
	List<User> findAll();
	
	
	@Transactional
	@Modifying 
	@Query(value="INSERT INTO user (password, user_id, user_name, role_id) VALUES (?1, ?2, ?3, ?4)",nativeQuery = true)
	void insert(String pa, String uid, String un, Long rId);
	
}
