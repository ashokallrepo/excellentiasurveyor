package com.excellentia.surveyor.login;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class LoginUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User name " + username+" not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user));
		
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(User user){
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

//		if(user.getRole().getName().equals("ADMIN")) {
//			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		}
//			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			

		
		return grantedAuthorities;
	}
	

}
