package com.excellentia.surveyor.surveyor_db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.insured.Insured;

@Service
public class SurveyorService implements ISurveyorService{
	
	@Autowired
	private SurveyorRepository ir;

	@Override
	public List<Surveyor> getSurveyor() {
		
		List<Surveyor> list = new ArrayList<Surveyor>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public Surveyor saveSurveyor(Surveyor sur) {
		Surveyor surObj = null;
		if(sur.getId() == null && sur.getName() !=null && !sur.getName().trim().isEmpty()) {
			List<Surveyor> silist = ir.getListOnName(sur.getName().trim());
			if(silist !=null && silist.size() > 0) {
				surObj = silist.get(0);
				surObj.setName(sur.getName());
				surObj.setEmail(sur.getEmail());
				surObj.setMobile(sur.getMobile());
			}else {
				surObj = sur;
			}
			
		}
		else if(sur.getId() !=null) {
			surObj = findById(sur.getId());
			surObj.setName(sur.getName());
			surObj.setEmail(sur.getEmail());
			surObj.setMobile(sur.getMobile());
		}
		if(surObj !=null)
			return ir.save(surObj);
		else
				return null;
	}

	@Override
	public Surveyor findById(Long id) {
		Surveyor obj =ir.findById(id).get();
		return obj;
	}
	

}
