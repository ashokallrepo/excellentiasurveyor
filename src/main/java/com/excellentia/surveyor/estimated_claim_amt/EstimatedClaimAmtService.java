package com.excellentia.surveyor.estimated_claim_amt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.registration_branch.RegistrationBranch;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

@Service
public class EstimatedClaimAmtService implements IEstimatedClaimAmtService{
	
	@Autowired
	private EstimatedClaimAmtRepository ir;

	@Override
	public List<EstimatedClaimAmt> getEstimatedClaimAmt() {
		
		List<EstimatedClaimAmt> list = new ArrayList<EstimatedClaimAmt>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public EstimatedClaimAmt saveEstimatedClaimAmt(EstimatedClaimAmt em) {
		EstimatedClaimAmt emObj = null;
		if(em.getId() == null && em.getValue() !=null && !em.getValue().trim().isEmpty()) {
			List<EstimatedClaimAmt> silist = ir.getListOnValue(em.getValue().trim());
			if(silist !=null && silist.size() > 0) {
				emObj= silist.get(0);
				emObj.setValue(em.getValue());
			}else {
				emObj = em;
			}
		}
		else if(em.getId() !=null) {
			emObj = findById(em.getId());
			emObj.setValue(em.getValue());
		}
		
		if(emObj!=null)
		return ir.save(emObj);
		else
			return null;
	}

	@Override
	public EstimatedClaimAmt findById(Long id) {
		EstimatedClaimAmt obj =ir.findById(id).get();
		return obj;
	}

	@Override
	public Map<Long, EstimatedClaimAmt> getRecordsInMap(List<EstimatedClaimAmt> li) {
		Map<Long, EstimatedClaimAmt> map = new HashMap<Long,EstimatedClaimAmt>();
		for(int i=0;i<li.size();i++) {
			EstimatedClaimAmt obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

	@Override
	public Map<Long, EstimatedClaimAmt> getListOnMultipleIds(List<Long> ids) {
		List<EstimatedClaimAmt> li =ir.getListOnMultipleIds(ids);
		return getRecordsInMap(li);
	}
	

}
