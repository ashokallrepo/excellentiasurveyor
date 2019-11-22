package com.excellentia.surveyor.insurer;

import java.util.List;

public interface IInsurerService {
	
	List<Insurer> getInsurers();
	Insurer saveInsurer(Insurer ins);
	Insurer findById(Long id);

}
