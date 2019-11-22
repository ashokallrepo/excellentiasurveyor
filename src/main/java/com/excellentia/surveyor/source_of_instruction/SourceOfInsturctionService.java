package com.excellentia.surveyor.source_of_instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceOfInsturctionService implements ISourceOfInsturction{

	
	@Autowired
	private SourceOfInsturctionRepository sr;
	
	@Override
	public List<SourceOfInstruction> getSourceOfInstructionList() {
		List<SourceOfInstruction> list = new ArrayList<SourceOfInstruction>();
		sr.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public SourceOfInstruction saveSOIns(SourceOfInstruction soi) {
		
		SourceOfInstruction soiObj = null;
		if(soi.getId() == null && soi.getName() !=null && !soi.getName().trim().isEmpty() && soi.getInsurer()!=null) {
			List<SourceOfInstruction> silist = sr.getListOnNameAndInsurer(soi.getName(), soi.getInsurer());
			if(silist !=null && silist.size() > 0) {
				soiObj = silist.get(0);
				soiObj.setAddress(soi.getAddress());
				soiObj.setCity(soi.getCity());
				soiObj.setContactNo(soi.getContactNo());
				soiObj.setEmail(soi.getEmail());
				soiObj.setInsurer(soi.getInsurer());
				soiObj.setName(soi.getName());
				soiObj.setPincode(soi.getPincode());
				soiObj.setOfficeCodeRoDo(soi.getOfficeCodeRoDo());
			}else {
				soiObj = soi;
			}
		}
		else if(soi.getId() != null) {
			soiObj = findById(soi.getId());
			soiObj.setAddress(soi.getAddress());
			soiObj.setCity(soi.getCity());
			soiObj.setContactNo(soi.getContactNo());
			soiObj.setEmail(soi.getEmail());
			soiObj.setInsurer(soi.getInsurer());
			soiObj.setName(soi.getName());
			soiObj.setPincode(soi.getPincode());
			soiObj.setOfficeCodeRoDo(soi.getOfficeCodeRoDo());
		}
		
		if(soiObj!=null)
		return sr.save(soiObj);
		else
			return null;
	}

	@Override
	public SourceOfInstruction findById(Long id) {
		SourceOfInstruction obj =sr.findById(id).get();
		return obj;
	}

	@Override
	public Map<Long, SourceOfInstruction> getRecordsInMap(List<SourceOfInstruction> li) {

		Map<Long, SourceOfInstruction> map = new HashMap<Long,SourceOfInstruction>();
		for(int i=0;i<li.size();i++) {
			SourceOfInstruction obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

	@Override
	public Map<Long, SourceOfInstruction> getListOnMultipleIds(List<Long> ids) {
		List<SourceOfInstruction> li = sr.getListOnMultipleIds(ids);
		return getRecordsInMap(li);
	}
	
	

}
