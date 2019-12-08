package com.excellentia.surveyor.login;

import java.util.List;
import java.util.Map;

public interface IRoleService {
	Role findById(Long id);
	Role getRoleByName(String name);
	Map<Long, Role> getRecordsInMap(List<Role> li);

}
