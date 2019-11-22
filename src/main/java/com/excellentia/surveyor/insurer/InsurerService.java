package com.excellentia.surveyor.insurer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.insured.Insured;

@Service
public class InsurerService implements IInsurerService{
	
	@Autowired
	private InsurerRepository ir;

	@Override
	public List<Insurer> getInsurers() {
		
		List<Insurer> list = new ArrayList<Insurer>();
		ir.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public Insurer saveInsurer(Insurer ins) {
		Insurer insObj = null;
		if(ins.getId() == null && ins.getName() !=null && !ins.getName().trim().isEmpty() && ins.getType() !=null && !ins.getType().trim().isEmpty() 
				&& ins.getState() !=null && !ins.getState().trim().isEmpty()) {
			List<Insurer> silist = ir.getListOnName(ins.getName().trim(), ins.getType().trim(), ins.getState());
			if(silist !=null && silist.size() > 0) {
				insObj= silist.get(0);
				insObj.setGstNo(ins.getGstNo());
				insObj.setState(ins.getState());
				insObj.setName(ins.getName());
				insObj.setType(ins.getType());
			}else {
				insObj = ins;
			}
		}
		else if(ins.getId() !=null) {
			insObj = findById(ins.getId());
			insObj.setGstNo(ins.getGstNo());
			insObj.setState(ins.getState());
			insObj.setName(ins.getName());
			insObj.setType(ins.getType());
		}
		if(insObj !=null)
		return ir.save(insObj);
		else
				return null;
	}

	@Override
	public Insurer findById(Long id) {
		Insurer obj =ir.findById(id).get();
		return obj;
	}
	

}
