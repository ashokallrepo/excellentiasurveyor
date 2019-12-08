package com.excellentia.surveyor.fieldstaff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.job_status.JobStatus;
import com.excellentia.surveyor.login.User;
import com.excellentia.surveyor.login.UserRepository;

@Service
public class FieldStaffService implements IFieldStaffService{
	
	@Autowired
	private FieldStaffRepository ir;
	
	@Autowired
	private UserRepository ur;

	@Override
	public List<FieldStaff> getFieldStaff() {
		
		List<FieldStaff> list = new ArrayList<FieldStaff>();
		ir.findAll().forEach(e -> list.add(e));
		
		//for user name ---
		for(int i=0;i<list.size();i++){
			FieldStaff fsObj = list.get(i);
			User obj =ur.findById(fsObj.getUserId()).get();
			fsObj.setUserName(obj.getUserName());
		}
		
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

	@Override
	public FieldStaff findByUserId(Long id) {
		return ir.findByUserId(id);
	}

	@Override
	public Map<Long, FieldStaff> getRecordsInMap(List<FieldStaff> li) {
		if(li == null){
			li = new ArrayList<FieldStaff>();
		}
		if(li != null && li.size() == 0){
			li = ir.findAll();
		}
		Map<Long, FieldStaff> map = new HashMap<Long,FieldStaff>();
		for(int i=0;i<li.size();i++) {
			FieldStaff obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

	@Override
	public FieldStaff getListOnName(String name){
		List<FieldStaff> list = ir.getListOnName(name);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return new FieldStaff();
	}
	

}
