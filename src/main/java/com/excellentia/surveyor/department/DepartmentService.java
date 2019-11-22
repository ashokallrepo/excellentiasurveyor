package com.excellentia.surveyor.department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

@Service
public class DepartmentService implements IDepartmentService{
	
	@Autowired
	private DepartmentRepository ir;

	@Override
	public List<Department> getDepartment() {
		
		List<Department> list = new ArrayList<Department>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public Department saveDepartment(Department dep) {
		Department depObj = null;
		if(dep.getId() == null && dep.getName() !=null && !dep.getName().trim().isEmpty()) {
			List<Department> silist = ir.getListOnName(dep.getName().trim());
			if(silist !=null && silist.size() > 0) {
				depObj = silist.get(0);
				depObj.setName(dep.getName());
				depObj.setType(dep.getType());
				depObj.setDescription(dep.getDescription());
			}else {
				depObj = dep;
			}
		}
		else if(dep.getId() !=null) {
			depObj = findById(dep.getId());
			depObj.setName(dep.getName());
			depObj.setType(dep.getType());
			depObj.setDescription(dep.getDescription());
		}
		if(depObj != null)
			return ir.save(depObj);
		else
			return null;
	}

	@Override
	public Department findById(Long id) {
		Department obj =ir.findById(id).get();
		return obj;
	}

	@Override
	public Map<Long, Department> getRecordsInMap(List<Department> li) {

		Map<Long, Department> map = new HashMap<Long,Department>();
		for(int i=0;i<li.size();i++) {
			Department obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

	@Override
	public Map<Long, Department> getListOnMultipleIds(List<Long> ids) {
		List<Department> li = ir.getListOnMultipleIds(ids);
		return getRecordsInMap(li);
	}
	

}
