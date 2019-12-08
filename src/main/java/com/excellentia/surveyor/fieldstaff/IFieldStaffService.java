package com.excellentia.surveyor.fieldstaff;

import java.util.List;
import java.util.Map;

public interface IFieldStaffService {
	
	List<FieldStaff> getFieldStaff();
	FieldStaff saveFieldStaff(FieldStaff ins);
	FieldStaff findById(Long id);
	FieldStaff findByUserId(Long id);
	

	Map<Long,FieldStaff> getRecordsInMap(List<FieldStaff> li);
	FieldStaff getListOnName(String name);
	

}
