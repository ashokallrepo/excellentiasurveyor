package com.excellentia.surveyor.broker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.insured.Insured;

@Service
public class BrokerService implements IBrokerService{
	
	
	@Autowired
	private BrokerRepository br;

	@Override
	public List<Broker> getBrokers() {
		List<Broker> list = new ArrayList<Broker>();
		br.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Broker saveBroker(Broker brk) {
		Broker obj = null;
		if(brk.getId() == null && brk.getName() !=null && !brk.getName().trim().isEmpty()) {
			List<Broker> silist = br.getListOnName(brk.getName().trim());
			if(silist !=null && silist.size() > 0) {
				obj= silist.get(0);
				obj.setName(brk.getName());
			}else {
				obj = brk;
			}
		}
		else if(brk.getId() != null) {
			obj = findById(brk.getId());
			obj.setName(brk.getName());
		}
		if(obj !=null)
		return br.save(obj);
		else
			return null;
	}

	@Override
	public Broker findById(Long id) {
		return br.findById(id).get();
	}
	

}
