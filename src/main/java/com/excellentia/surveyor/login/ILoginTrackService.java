package com.excellentia.surveyor.login;

public interface ILoginTrackService {
	
	LoginTrack findByUserName(String un);
	void createLoginTrack(LoginTrack  lt);
	void updateLoginTrack(LoginTrack lt);

}
