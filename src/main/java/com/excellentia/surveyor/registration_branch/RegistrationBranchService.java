package com.excellentia.surveyor.registration_branch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.sub_dept.SubDepartment;

@Service
public class RegistrationBranchService implements IRegistrationBranchService{
	
	@Autowired
	private RegistrationBranchRepository ir;

	@Override
	public List<RegistrationBranch> getRegistrationBranch() {
		
		List<RegistrationBranch> list = new ArrayList<RegistrationBranch>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public RegistrationBranch saveRegistrationBranch(RegistrationBranch re) {
		RegistrationBranch reObj = null;
		if(re.getId() == null && re.getName() !=null && !re.getName().trim().isEmpty()) {
			List<RegistrationBranch> silist = ir.getListOnName(re.getName().trim());
			if(silist !=null && silist.size() > 0) {
				reObj= silist.get(0);
				reObj.setName(re.getName());
			}else {
				reObj = re;
			}
		}
		
		else if(re.getId() !=null) {
			reObj = findById(re.getId());
			reObj.setName(re.getName());
		}
		
		if(reObj!=null)
		return ir.save(reObj);
		else
			return null;
	}

	@Override
	public RegistrationBranch findById(Long id) {
		RegistrationBranch obj =ir.findById(id).get();
		return obj;
	}
	

}
