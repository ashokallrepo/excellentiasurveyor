package com.excellentia.surveyor.surveyor_db;

import java.util.List;

public interface ISurveyorService {
	
	List<Surveyor> getSurveyor();
	Surveyor saveSurveyor(Surveyor ins);
	Surveyor findById(Long id);

}
