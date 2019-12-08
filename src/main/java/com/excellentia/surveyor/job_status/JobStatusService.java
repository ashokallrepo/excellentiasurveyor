package com.excellentia.surveyor.job_status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.fieldstaff.FieldStaff;
import com.excellentia.surveyor.fieldstaff.IFieldStaffService;
import com.excellentia.surveyor.login.IRoleService;
import com.excellentia.surveyor.login.Role;

@Service
public class JobStatusService implements IJobStatusService{
	@Autowired
	private JobStatusRepository js;

	@Autowired
	private IRoleService rl;

	@Autowired
	private IFieldStaffService fs;

	
	@Override
	public List<JobStatus> getJobStatus() {
		List<JobStatus> list = new ArrayList<JobStatus>();
		js.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public JobStatus findById(Long id) {
		JobStatus obj =js.findById(id).get();
		return obj;
	}
	
	@Override
	public Map<Long, JobStatus> getListOnMultipleIds(List<Long> ids) {
		List<JobStatus> li = new ArrayList<JobStatus>();
		if(ids.size()>0)
		{
			li = js.getListOnMultipleIds(ids);
		}
		
		return getRecordsInMap(li);
	}
	
	@Override
	public Map<Long, JobStatus> getRecordsInMap(List<JobStatus> li) {
		Map<Long, JobStatus> map = new HashMap<Long,JobStatus>();
		for(int i=0;i<li.size();i++) {
			JobStatus obj = li.get(i);
			map.put(obj.getId(), obj);
		}
		return map;
	}

	@Override
	public List<JobStatus> getJobStatusBasedOnRole(String role) {
		List<JobStatus> list = new ArrayList<JobStatus>();
		List<JobStatus> listTemp = new ArrayList<JobStatus>();
		if(role.equals("FIELD_SURVEYOR")){
			Role rlObj = rl.getRoleByName("FIELD_SURVEYOR"); 
			Long rid = rlObj.getId();
			js.findAll().forEach(e -> list.add(e));
			for(int i=0;i<list.size();i++){
				JobStatus jsObj = list.get(i);
				String[] roles = jsObj.getRoles()!=null ?jsObj.getRoles().split(",") : null;
				for(int k=0;roles != null &&  k<roles.length;k++){
					if(rid.toString().equals(roles[k])){
						listTemp.add(jsObj);
						break;
					}
				}
			}
		}
		return listTemp;
	}

	@Override
	public JobStatus findByStatusName(String name) {
		List<JobStatus> list = new ArrayList<JobStatus>();
		list = js.findByStatusName(name);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
