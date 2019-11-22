package com.excellentia.surveyor.mis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentia.surveyor.department.Department;
import com.excellentia.surveyor.department.IDepartmentService;
import com.excellentia.surveyor.estimated_claim_amt.EstimatedClaimAmt;
import com.excellentia.surveyor.estimated_claim_amt.IEstimatedClaimAmtService;
import com.excellentia.surveyor.insured.IInsuredService;
import com.excellentia.surveyor.insured.Insured;
import com.excellentia.surveyor.source_of_instruction.ISourceOfInsturction;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;

@Service
public class MISService implements IMISService{
	
	@Autowired
	private MISRepository mr;

	@Autowired
	private ISourceOfInsturction sr;
	
	@Autowired
	private IInsuredService ir;
	
	@Autowired
	private IDepartmentService dr;
	
	@Autowired
	private IEstimatedClaimAmtService er;

	@Override
	public List<MIS> getMISs() {
		List<MIS> list = new ArrayList<MIS>();
		mr.findAll().forEach(e -> list.add(e));
		
		List<Long> sids = new ArrayList<Long>();
		List<Long> insids = new ArrayList<Long>();
		List<Long> deptids = new ArrayList<Long>();
		List<Long> estids = new ArrayList<Long>();
		for(int i=0;i<list.size();i++) {
			MIS obj = list.get(i);
			if(obj.getSrcOfInst()!=null) {
				sids.add(obj.getSrcOfInst());
			}
			if(obj.getInsured()!=null) {
				insids.add(obj.getInsured());
			}
			if(obj.getEstClaimAmt()!=null) {
				deptids.add(obj.getEstClaimAmt());
			}
			if(obj.getDeptName()!=null) {
				estids.add(obj.getDeptName()); 
			}
			
		}
		
		Map<Long,SourceOfInstruction> smap= sr.getListOnMultipleIds(sids);
		Map<Long,Insured> inmap= ir.getListOnMultipleIds(insids);
		Map<Long,Department> dmap= dr.getListOnMultipleIds(deptids);
		Map<Long,EstimatedClaimAmt> emap= er.getListOnMultipleIds(estids);
		
		for(int i=0;i<list.size();i++) {
			MIS obj = list.get(i);
			
			if(!smap.isEmpty() && smap.containsKey(obj.getSrcOfInst())) {
				obj.setSrcOfInstName(smap.get(obj.getSrcOfInst()).getName());
			}
			if(!inmap.isEmpty() && inmap.containsKey(obj.getInsured())) {
				obj.setInsuredName(inmap.get(obj.getInsured()).getName());
				Long mob = inmap.get(obj.getInsured()).getMobile();
				if(mob != null)
					obj.setInsuredContact(mob.toString());
			}
			if(!dmap.isEmpty() && dmap.containsKey(obj.getDeptName())) {
				obj.setDeptNameVal(dmap.get(obj.getDeptName()).getName());
			}
			if(!emap.isEmpty() && emap.containsKey(obj.getEstClaimAmt())) {
				obj.setEstClaimAmtValue(emap.get(obj.getEstClaimAmt()).getValue());
			}
			
		}
		
		return list;
	}
	
	public Date combineDateAndTime(String d, String t)throws Exception {
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
	    
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    Date dt = dateFormat.parse(t + ":00:00");
	    
	    String startingDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	    String startingTime = new SimpleDateFormat("HH:mm:ss").format(dt);
	    
	    date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startingDate + " " + startingTime);
	    
	    System.out.println(date);
	    
	    return date;
	}

	@Override
	public MIS saveMIS(MIS mis) {
		MIS misObj = null;
		MIS misNew = null;
		String jobno = "";
	    
	
		if(mis.getJobNo() != null && !mis.getJobNo().trim().isEmpty()) { //for edit
			List<MIS> silist =  mr.getListOnJobNo(mis.getJobNo());
			if(silist !=null && silist.size() > 0) {
				misNew= silist.get(0);
			}
			else
			{
				System.out.println("Job number not found");
				return null;
			}
		}
		else { //for new
		    Calendar cal = Calendar.getInstance(); 
		    cal.setTime(mis.getRegDt());
		    int month = cal.get(Calendar.MONTH) + 1;
		    int year = cal.get(Calendar.YEAR); 
		    jobno = year + "/" +month +"/KOL/" + mis.getInsType() + "/";
		    List<MIS> silist =  mr.getLastJobNo(jobno);
		    if(silist !=null && silist.size()>0) {
		    	long  max = 0;
			    for(int i =0;i<silist.size();i++) {
			    	String s = silist.get(i).getJobNo();
			    	int k = s.lastIndexOf("/");
				    s = s.substring(k+1);
				    long v = Long.parseLong(s);
				    if( v > max ) {
				    	max = v;
				    }
			    }
			    jobno = jobno + (max+1);
			    mis.setJobNo(jobno);
		    }
		    else {
		    	 jobno = jobno + 1;
				  mis.setJobNo(jobno);
		    }
		}
		
		if(misNew !=null) {
//			misObj = findById(mis.getId());
			misObj = misNew;
			misObj.setJobNo(mis.getJobNo());
			misObj.setInsurer(mis.getInsurer());
			misObj.setBroker(mis.getBroker());
			misObj.setInsurerClaimNo(mis.getInsurerClaimNo());
			misObj.setDtTimeIntimation(mis.getDtTimeIntimation());
			misObj.setInsured(mis.getInsured());
			misObj.setRepName(mis.getRepName());
			misObj.setPolicyNo(mis.getPolicyNo());
			misObj.setEstClaimAmt(mis.getEstClaimAmt());
			misObj.setRegBranch(mis.getRegBranch());
			misObj.setMailSendToBranch(mis.getMailSendToBranch());
			misObj.setLocationOfLoss(mis.getLocationOfLoss());
			misObj.setDeptName(mis.getDeptName());
			misObj.setGrNO(mis.getGrNO());
			misObj.setInvoiceNo(mis.getInvoiceNo());
			misObj.setRegDt(mis.getRegDt());
			misObj.setGrDate(mis.getGrDate());
			misObj.setInvoiceDt(mis.getInvoiceDt());
			misObj.setSubDept(mis.getSubDept());
			misObj.setSpecialInfo(mis.getSpecialInfo());
			misObj.setSrcOfInst(mis.getSrcOfInst());
			misObj.setUploadFile(mis.getUploadFile());
			misObj.setSurveyor(mis.getSurveyor());
			misObj.setFieldStaff(mis.getFieldStaff());
		}
		else {
			misObj = mis;
		}
		
		if(misObj != null)
			return mr.save(misObj);
		else
				return null;
	}

	@Override
	public MIS findById(Long id) {
		MIS obj =mr.findById(id).get();
		return obj;
	}

}
