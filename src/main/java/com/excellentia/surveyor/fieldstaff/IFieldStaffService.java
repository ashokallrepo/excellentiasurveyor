package com.excellentia.surveyor.fieldstaff;

import java.util.List;

public interface IFieldStaffService {
	
	List<FieldStaff> getFieldStaff();
	FieldStaff saveFieldStaff(FieldStaff ins);
	FieldStaff findById(Long id);

}
