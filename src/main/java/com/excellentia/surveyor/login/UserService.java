package com.excellentia.surveyor.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository urep;

	@Override
	public List<User> getUser() {
		List<User> list = new ArrayList<User>();
		urep.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public User saveUser(User ur) {
		return urep.save(ur);
	}

	@Override
	public User findById(Long id) {
		User obj =urep.findById(id).get();
		return obj;
	}

	@Override
	public void saveNewUser(User ur) {
		 urep.insert("$2a$10$qyMiapuYY8XXKj2EHoWUL.zJhju7CP4QT8G7a5vMszLw8WUmdH23C",ur.getUserId(),ur.getUserName(),2l);
	}

	@Override
	public User findByUsername(String username) {
		
		return urep.findByUsername(username);
	}
	
	
	

}
