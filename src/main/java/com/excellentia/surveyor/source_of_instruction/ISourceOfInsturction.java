package com.excellentia.surveyor.source_of_instruction;

import java.util.List;
import java.util.Map;

public interface ISourceOfInsturction {
	
	List<SourceOfInstruction> getSourceOfInstructionList();
	
	SourceOfInstruction saveSOIns(SourceOfInstruction soi);
	SourceOfInstruction findById(Long id);
	
	Map<Long,SourceOfInstruction> getRecordsInMap(List<SourceOfInstruction> li);
	Map<Long, SourceOfInstruction> getListOnMultipleIds(List<Long> ids);
	
	

}
