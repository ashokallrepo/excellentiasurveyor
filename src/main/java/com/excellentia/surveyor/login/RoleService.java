package com.excellentia.surveyor.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.fieldstaff.FieldStaff;

@Service
public class RoleService implements IRoleService{

	@Autowired
	private RoleRepository rr;
	
	@Override
	public Role findById(Long id) {
		Role obj =rr.findById(id).get();
		return obj;
	}

	@Override
	public Role getRoleByName(String name) {
		return rr.getRoleByName(name);
	}
	
	@Override
	public Map<Long, Role> getRecordsInMap(List<Role> li) {
		if(li == null){
			li = new ArrayList<Role>();
		}
		if(li != null && li.size() == 0){
			li = rr.findAll();
		}
		Map<Long, Role> map = new HashMap<Long,Role>();
		for(int i=0;i<li.size();i++) {
			Role obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

}
