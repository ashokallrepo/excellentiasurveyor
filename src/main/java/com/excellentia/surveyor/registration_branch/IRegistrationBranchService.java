package com.excellentia.surveyor.registration_branch;

import java.util.List;

public interface IRegistrationBranchService {
	
	List<RegistrationBranch> getRegistrationBranch();
	RegistrationBranch saveRegistrationBranch(RegistrationBranch ins);
	RegistrationBranch findById(Long id);

}
