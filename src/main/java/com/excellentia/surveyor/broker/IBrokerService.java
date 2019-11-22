package com.excellentia.surveyor.broker;

import java.util.List;

public interface IBrokerService {
	
	List<Broker> getBrokers();
	Broker saveBroker(Broker brk);
	Broker findById(Long id);

}
