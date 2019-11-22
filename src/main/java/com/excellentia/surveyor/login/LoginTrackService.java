package com.excellentia.surveyor.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginTrackService implements ILoginTrackService{
	
	@Autowired
	private LoginTrackRepository ltr;


	@Override
	public void createLoginTrack(LoginTrack lt) {
		
	}

	@Override
	public void updateLoginTrack(LoginTrack lt) {
		LoginTrack ltn = (LoginTrack) ltr.findByUserName(lt.getUserName());
		if(ltn != null) {
			ltn.setToken(lt.getToken());
			ltn.setDateTime(lt.getDateTime());
			ltr.save(ltn);	
		}
		else {
			ltr.save(lt);	
		}
		
	}

	@Override
	public LoginTrack findByUserName(String un) {
		return ltr.findByUserName(un);
	}

}
