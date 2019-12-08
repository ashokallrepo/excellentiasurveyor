package com.excellentia.surveyor.mis;

import java.util.Date;
import java.util.List;

public interface IMISService {

	List<MIS> getMISs();
	List<MIS> getMISsBasedOnUserRole(String un, String role);
	MIS saveMIS(MIS mis);
	MIS findById(Long id);
	
	Date combineDateAndTime(String d, String t)throws Exception; 
}
