package com.excellentia.surveyor.login;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface IUserService {

	List<User> getUser();
	User saveUser(User ur);
	void saveNewUser(User ur);
	User findById(Long id);
	User findByUsername(String username);
}
