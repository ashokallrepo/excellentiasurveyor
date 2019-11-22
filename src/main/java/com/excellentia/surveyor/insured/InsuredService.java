package com.excellentia.surveyor.insured;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.estimated_claim_amt.EstimatedClaimAmt;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

@Service
public class InsuredService implements IInsuredService{
	
	@Autowired
	private InsuredRepository ir;

	@Override
	public List<Insured> getInsured() {
		
		List<Insured> list = new ArrayList<Insured>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public Insured saveInsured(Insured ins) {
		Insured insObj = null;
		if(ins.getId() == null && ins.getName() !=null && !ins.getName().trim().isEmpty()) {
			List<Insured> silist = ir.getListOnValue(ins.getName().trim());
			if(silist !=null && silist.size() > 0) {
				insObj= silist.get(0);
				insObj.setAdd_on_policy_doc(ins.getAdd_on_policy_doc());
				insObj.setMobile(ins.getMobile());
				insObj.setEmail(ins.getEmail());
				insObj.setName(ins.getName());
			}else {
				insObj = ins;
			}
		}
		else if(ins.getId() !=null) {
			insObj = findById(ins.getId());
			insObj.setAdd_on_policy_doc(ins.getAdd_on_policy_doc());
			insObj.setMobile(ins.getMobile());
			insObj.setEmail(ins.getEmail());
			insObj.setName(ins.getName());
		}
		if(insObj != null)
		return ir.save(insObj);
		else
			return null;
	}

	@Override
	public Insured findById(Long id) {
		Insured obj =ir.findById(id).get();
		return obj;
	}

	@Override
	public Map<Long, Insured> getRecordsInMap(List<Insured> li) {
		Map<Long, Insured> map = new HashMap<Long,Insured>();
		for(int i=0;i<li.size();i++) {
			Insured obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

	@Override
	public Map<Long, Insured> getListOnMultipleIds(List<Long> ids) {
		List<Insured> li = ir.getListOnMultipleIds(ids);
		return getRecordsInMap(li);
	}
	

}
