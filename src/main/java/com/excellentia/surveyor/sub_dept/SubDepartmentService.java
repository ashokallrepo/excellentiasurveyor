package com.excellentia.surveyor.sub_dept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.department.Department;

@Service
public class SubDepartmentService implements ISubDepartmentService{
	
	@Autowired
	private SubDepartmentRepository ir;

	@Override
	public List<SubDepartment> getSubDepartment() {
		
		List<SubDepartment> list = new ArrayList<SubDepartment>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public SubDepartment saveSubDepartment(SubDepartment sd) {
		SubDepartment sdObj = null;
		if(sd.getId() == null && (sd.getName() == null || sd.getName().trim().isEmpty()))
			return null;
		
		if(sd.getId() == null && sd.getName() !=null && !sd.getName().trim().isEmpty()) {
			List<SubDepartment> silist = ir.getListOnName(sd.getName().trim(),sd.getDepartment());
			if(silist !=null && silist.size() > 0) {
				sdObj = silist.get(0);
				sdObj.setName(sd.getName());
			}
			else {
				sdObj = sd;
			}
		}
		else if(sd.getId() !=null) {
			sdObj = findById(sd.getId());
			sdObj.setName(sd.getName());
		}
		
		if(sdObj!=null)
		return ir.save(sdObj);
		else
			return null;
	}

	@Override
	public SubDepartment findById(Long id) {
		SubDepartment obj =ir.findById(id).get();
		return obj;
	}
	

}
