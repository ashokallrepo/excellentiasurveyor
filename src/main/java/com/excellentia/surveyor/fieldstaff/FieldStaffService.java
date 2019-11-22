package com.excellentia.surveyor.fieldstaff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.insured.Insured;

@Service
public class FieldStaffService implements IFieldStaffService{
	
	@Autowired
	private FieldStaffRepository ir;

	@Override
	public List<FieldStaff> getFieldStaff() {
		
		List<FieldStaff> list = new ArrayList<FieldStaff>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public FieldStaff saveFieldStaff(FieldStaff fs) {
		FieldStaff fsObj = null;
		if(fs.getId() == null && fs.getName() !=null && !fs.getName().trim().isEmpty()) {
			List<FieldStaff> silist = ir.getListOnName(fs.getName().trim());
			if(silist !=null && silist.size() > 0) { 
				fsObj= silist.get(0);
				fsObj.setName(fs.getName());
				fsObj.setEmail(fs.getEmail());
				fsObj.setMobile(fs.getMobile());
			}else {
				fsObj = fs;
			}
			
		}
		else if(fs.getId() !=null) { //for updating 
			fsObj = findById(fs.getId());
			fsObj.setName(fs.getName());
			fsObj.setEmail(fs.getEmail());
			fsObj.setMobile(fs.getMobile());
		}
		if(fsObj !=null)
			return ir.save(fsObj);
		else
				return null;
	}

	@Override
	public FieldStaff findById(Long id) {
		FieldStaff obj =ir.findById(id).get();
		return obj;
	}
	

}
