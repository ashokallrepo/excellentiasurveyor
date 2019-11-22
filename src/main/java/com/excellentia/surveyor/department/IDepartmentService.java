package com.excellentia.surveyor.department;

import java.util.List;
import java.util.Map;

import com.excellentia.surveyor.insured.Insured;

public interface IDepartmentService {
	
	List<Department> getDepartment();
	Department saveDepartment(Department ins);
	Department findById(Long id);
	
	Map<Long,Department> getRecordsInMap(List<Department> li);
	Map<Long, Department> getListOnMultipleIds(List<Long> ids);

}
