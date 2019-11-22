package com.excellentia.surveyor.login;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LoginTrackRepository extends CrudRepository<LoginTrack, Long> {
	LoginTrack findByUserName(String un);
}
