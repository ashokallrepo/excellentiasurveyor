package com.excellentia.surveyor.masterpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excellentia.surveyor.login.ILoginTrackService;
import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.shared.ApiResponse;



@CrossOrigin
@RestController
@RequestMapping("/apimaster")
public class MasterController {
	
	
	@Autowired
	ILoginTrackService logintrack;
	
	
	@GetMapping("/menu")
	public ApiResponse<String> getMenu(@RequestParam("token") String token) {
		
		System.out.println("token in menu ::  " + token);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String cpn = authentication.getName();
		System.out.println("menu.. " + cpn);
		LoginTrack lt = logintrack.findByUserName(cpn);
		
		if(lt.getToken().equals(token)) {
			return new ApiResponse<>(HttpStatus.OK.value(), "sucessfully returned" ,authentication.getAuthorities().toArray()[0]);	
		}
		
		return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), "invalid access" ,"invalid");
		
	}

}
