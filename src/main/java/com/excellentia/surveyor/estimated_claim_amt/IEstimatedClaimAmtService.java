package com.excellentia.surveyor.estimated_claim_amt;

import java.util.List;
import java.util.Map;

import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

public interface IEstimatedClaimAmtService {
	
	List<EstimatedClaimAmt> getEstimatedClaimAmt();
	EstimatedClaimAmt saveEstimatedClaimAmt(EstimatedClaimAmt ins);
	EstimatedClaimAmt findById(Long id);
	
	Map<Long,EstimatedClaimAmt> getRecordsInMap(List<EstimatedClaimAmt> li);
	Map<Long, EstimatedClaimAmt> getListOnMultipleIds(List<Long> ids);

}
