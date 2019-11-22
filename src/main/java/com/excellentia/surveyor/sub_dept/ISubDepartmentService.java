package com.excellentia.surveyor.sub_dept;

import java.util.List;

public interface ISubDepartmentService {
	
	List<SubDepartment> getSubDepartment();
	SubDepartment saveSubDepartment(SubDepartment ins);
	SubDepartment findById(Long id);

}
