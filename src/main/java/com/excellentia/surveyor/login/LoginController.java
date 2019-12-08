package com.excellentia.surveyor.login;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellentia.surveyor.shared.ApiResponse;

//change2
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
//@CrossOrigin(origins = "http://trythis.co.in")
@RestController
@RequestMapping("/apilogin")
public class LoginController {

	@Autowired
	ILoginTrackService logintrack;
	
	@GetMapping("/login")
	public ApiResponse<String> login() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String un = authentication.getName();
		BCryptPasswordEncoder be = new BCryptPasswordEncoder();
		long tm = System.currentTimeMillis();
		System.out.println(">>>  " + un +  " " + tm + " " + authentication.getAuthorities().toArray()[0]);
		String token = be.encode(un + tm + authentication.getAuthorities().toArray()[0]);
		LoginTrack lt = new LoginTrack();
		lt.setDateTime(new Date());
		lt.setToken(token);
		lt.setUserName(un);
		
		logintrack.updateLoginTrack(lt);
		return new ApiResponse<>(HttpStatus.OK.value(), "sucessfully logged in" ,token);
	}
	
	@PostMapping("/logout")
	public ApiResponse<Boolean> logout() {
		return new ApiResponse<>(HttpStatus.OK.value(), "sucessfully logged out" ,Boolean.TRUE);
	}
	
}
