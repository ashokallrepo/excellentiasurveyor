package com.excellentia.surveyor.insured;

import java.util.List;
import java.util.Map;

import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

public interface IInsuredService {
	
	List<Insured> getInsured();
	Insured saveInsured(Insured ins);
	Insured findById(Long id);
	
	Map<Long,Insured> getRecordsInMap(List<Insured> li);
	Map<Long, Insured> getListOnMultipleIds(List<Long> ids);
	

}
