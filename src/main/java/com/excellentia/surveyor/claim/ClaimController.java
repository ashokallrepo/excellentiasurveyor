package com.excellentia.surveyor.claim;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excellentia.surveyor.broker.Broker;
import com.excellentia.surveyor.broker.IBrokerService;
import com.excellentia.surveyor.department.Department;
import com.excellentia.surveyor.department.IDepartmentService;
import com.excellentia.surveyor.estimated_claim_amt.EstimatedClaimAmt;
import com.excellentia.surveyor.estimated_claim_amt.IEstimatedClaimAmtService;
import com.excellentia.surveyor.fieldstaff.FieldStaff;
import com.excellentia.surveyor.fieldstaff.IFieldStaffService;
import com.excellentia.surveyor.insured.IInsuredService;
import com.excellentia.surveyor.insured.Insured;
import com.excellentia.surveyor.insurer.IInsurerService;
import com.excellentia.surveyor.insurer.Insurer;
import com.excellentia.surveyor.login.ILoginTrackService;
import com.excellentia.surveyor.login.LoginTrack;
import com.excellentia.surveyor.mis.IMISService;
import com.excellentia.surveyor.mis.MIS;
import com.excellentia.surveyor.registration_branch.IRegistrationBranchService;
import com.excellentia.surveyor.registration_branch.RegistrationBranch;
import com.excellentia.surveyor.shared.ApiResponse;
import com.excellentia.surveyor.source_of_instruction.ISourceOfInsturction;
import com.excellentia.surveyor.source_of_instruction.SourceOfInstruction;
import com.excellentia.surveyor.sub_dept.ISubDepartmentService;
import com.excellentia.surveyor.sub_dept.SubDepartment;
import com.excellentia.surveyor.surveyor_db.ISurveyorService;
import com.excellentia.surveyor.surveyor_db.Surveyor;

@CrossOrigin
@RestController
@RequestMapping("/apiclaim")
public class ClaimController {
	
	@Autowired
	ILoginTrackService logintrack;
	
	@Autowired
	IInsurerService insService;
	
	@Autowired
	ISourceOfInsturction sofInService;
	
	@Autowired
	IBrokerService brSerivce;
	
	
	@Autowired
	IInsuredService insdSerivce;
	
	
	@Autowired
	IEstimatedClaimAmtService ecadSerivce;
	
	@Autowired
	IRegistrationBranchService rbSerivce;
	
	@Autowired
	IDepartmentService depSerivce;
	
	
	
	@Autowired
	ISubDepartmentService sdSerivce;
	
	@Autowired
	IMISService misSerivce;
	
	@Autowired
	ISurveyorService surSerivce;
	
	@Autowired
	IFieldStaffService fsSerivce;
	
	Insured insd = null;
	Department dept = null;
	SubDepartment sdept = null;
	RegistrationBranch rb = null;
	RegistrationBranch mrb = null;
	EstimatedClaimAmt ecl = null; 
	Surveyor surv = null;
	FieldStaff flds = null;
		
	
	@GetMapping("/lookupdata")
	public ApiResponse<Object> getLookupData(@RequestParam("token") String token) {
		
		System.out.println("token in menu ::  " + token);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String cpn = authentication.getName();
		System.out.println("menu.. " + cpn);
		LoginTrack lt = logintrack.findByUserName(cpn);
		List resList = new ArrayList();
		
		
		if(lt.getToken().equals(token)) {
			
			List<Insurer> insurers = insService.getInsurers();
			List<SourceOfInstruction> soIns = sofInService.getSourceOfInstructionList();
			List<Broker> broker = brSerivce.getBrokers();
			List<Insured> insd = insdSerivce.getInsured();
			List<EstimatedClaimAmt> ecasd = ecadSerivce.getEstimatedClaimAmt();
			List<RegistrationBranch> rbsd = rbSerivce.getRegistrationBranch();
			List<Department> depsd = depSerivce.getDepartment();
			List<SubDepartment> subdept = sdSerivce.getSubDepartment();
			List<Surveyor> surlist = surSerivce.getSurveyor();
			List<FieldStaff> fsList = fsSerivce.getFieldStaff();
			
			
			resList.add(insurers);
			resList.add(soIns);
			resList.add(broker);
			resList.add(insd);
			resList.add(ecasd);
			resList.add(rbsd);
			resList.add(depsd);
			resList.add(subdept);
			resList.add(surlist);
			resList.add(fsList);
			
			
			return new ApiResponse<>(HttpStatus.OK.value(), "sucessfully returned" ,resList);	
		}
		
		return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), "Invalid Access" ,"invalid");
		
	}
	private String validation(ClaimRequestDTO req) {
		String msg = "";
		if(req.getInsurerSelected() == null || req.getInsurerSelected().trim().isEmpty()) {
			msg = "Please proivde Insurer";
		}
		else if(req.getStateSelected() == null || req.getStateSelected().trim().isEmpty()) {
			msg = "Please proivde State";
		}
		else if(req.getTypeSelected() == null || req.getTypeSelected().trim().isEmpty()) {
			msg = "Please proivde Insurer type";
		}
		else if(req.getSrcOfInsSelected() == null || req.getSrcOfInsSelected().trim().isEmpty()) {
			msg = "Please proivde Source Of Instruction";
		}
		else if(req.getContactNo() == null || req.getContactNo().trim().isEmpty()) {
			msg = "Please proivde Insurer Contact No.";
		}
		else if(req.getDate() == null || req.getDate().trim().isEmpty()) {
			msg = "Please proivde Date of intimation";
		}
		else if(req.getTime() == null || req.getTime().trim().isEmpty()) {
			msg = "Please proivde Time of intimation";
		}
		else if(req.getInsuredSelected() == null || req.getInsuredSelected().trim().isEmpty()) {
			msg = "Please proivde Insured Name ";
		}
		else if(req.getRegBranchSelected() == null || req.getRegBranchSelected().trim().isEmpty()) {
			msg = "Please proivde Registration Branch";
		}
		else if(req.getRegDate() == null) {
			msg = "Please proivde Registration Date";
		}
		else if(req.getDeptSelected() == null || req.getDeptSelected().trim().isEmpty()) {
			msg = "Please proivde Department ";
		}
		else if(req.getEstClaimAmtSelected() == null || req.getEstClaimAmtSelected().trim().isEmpty()) {
			msg = "Please proivde Estimation claim Amt ";
		}
		
		
		if(req.getInsuredContactNo() != null && !req.getInsuredContactNo().trim().isEmpty()) {
			try
			{
				Long.parseLong(req.getInsuredContactNo());
			}
			catch(Exception e) {
				e.printStackTrace();
				msg = "Please proivde Correct Insured Contact Number";	
			}
			
		}
		if(req.getSurveryorcontact() != null && !req.getSurveryorcontact().trim().isEmpty()) {
			try
			{
				Long.parseLong(req.getSurveryorcontact());
			}
			catch(Exception e) {
				e.printStackTrace();
				msg = "Please proivde Correct Surveyor Contact Number";	
			}
			
		}
		if(req.getFeildStaffContact() != null && !req.getFeildStaffContact().trim().isEmpty()) {
			try
			{
				Long.parseLong(req.getFeildStaffContact());
			}
			catch(Exception e) {
				e.printStackTrace();
				msg = "Please proivde Correct Field Staff Contact Number";	
			}
			
		}
		
		
		return msg;
	}
	
	@PostMapping("/getAClaim")
    public ApiResponse<Object> getAClaim(@RequestBody ClaimRequestDTO req){
		List resList = new ArrayList();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String cpn = authentication.getName();
		LoginTrack lt = logintrack.findByUserName(cpn);
		String msg = "";
		
		if(lt.getToken().equals(req.token)) {
			Long id = null;
			try {
				id = req.getMisid() == null ? null : req.getMisid();
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Incorrect ID" ,"server error");
			}
			MIS misobj = misSerivce.findById(id);
			if(misobj !=null)
			{
				resList.add(misobj);
				return new ApiResponse<>(HttpStatus.OK.value(), "Success",resList);
			}

			return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Unable to find data","server error");
			
			
		}
		
		return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), "Invalid Access" ,"invalid");
	}
	
	@PostMapping("/getClaimDetails")
    public ApiResponse<Object> getClaimDetails(@RequestBody ClaimRequestDTO req){
		List resList = new ArrayList();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String cpn = authentication.getName();
		LoginTrack lt = logintrack.findByUserName(cpn);
		String msg = "";
		
		if(lt.getToken().equals(req.token)) {
			List<MIS> list = misSerivce.getMISs();
			if(list.size() > 0) {
				resList = list;
			}
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Success",resList);
			
		}
		
		 return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), "Invalid Access" ,"invalid");
	}
	
	@PostMapping("/createClaim")
    public ApiResponse<Object> createClaim(@RequestBody ClaimRequestDTO req){
		System.out.println(req);
		List resList = new ArrayList();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String cpn = authentication.getName();
		LoginTrack lt = logintrack.findByUserName(cpn);
		String msg = "";
		
		if(lt.getToken().equals(req.token)) {
			
			try {
				msg = validation(req);
				if(msg.isEmpty()) {
					
					Insurer obj = new Insurer();
					Long id = req.getId()!=null && !req.getId().trim().isEmpty() ? Long.parseLong(req.getId()): null;
					obj.setId(id);
					obj.setState(req.getStateSelected());
					obj.setGstNo(req.getGst());
					obj.setName(req.getInsurerSelected());
					obj.setType(req.getTypeSelected());
					obj = insService.saveInsurer(obj);
					
					if(obj != null) { //save source of instruction 
						SourceOfInstruction soi = new SourceOfInstruction(); 
						Long sid = req.getSrcOfInsId() != null ? req.getSrcOfInsId(): null;
						soi.setId(sid);
						soi.setAddress(req.getAdd());
						soi.setCity(null);
						soi.setContactNo(req.getContactNo());
						soi.setEmail(req.getEmail());
						soi.setInsurer(obj.getId());
						soi.setName(req.getSrcOfInsSelected());
						soi.setPincode(null);
						soi.setOfficeCodeRoDo(null);
						
						soi = sofInService.saveSOIns(soi);
						
						if(soi != null) {
							
							Broker brkr = new Broker();
							Long bid = req.getBrokerId() != null ? req.getBrokerId() : null;
							brkr.setId(bid);
							if(req.getBrokerSelected() != null && !req.getBrokerSelected().trim().isEmpty()) {
								brkr.setName(req.getBrokerSelected());
								brkr = brSerivce.saveBroker(brkr);	
							}
							
							if(brkr == null) {
								msg = "Unable to save Broker details";
							}
							
							//save insured details --------------
							
							msg = saveInsured(req);
							if(msg.isEmpty()) {
								msg = saveEstClaimAmt(req);
								if(msg.isEmpty()) {
									msg = saveRegBranch(req);
									if(msg.isEmpty()) {
										msg = saveMailToRegBranch(req);
										if(msg.isEmpty()) {
											if(req.getDeptSelected() !=null)
												msg = saveDept(req);
										}
									}
										
								}
							}
							
							//Assigned to job -------
							if(msg.isEmpty()) {
								msg = saveSurveyor(req);
								if(msg.isEmpty()) {
									msg = saveFieldStaff(req);
								}
							}
							
							//save MIS details ------------------
							if(msg.isEmpty()) {
								MIS mis = new MIS();
								mis.setJobNo(req.getJobNo());
								mis.setInsType(obj.getType());
								mis.setInsurer(obj.getId());
								mis.setSrcOfInst(soi.getId());
								mis.setBroker(brkr.getId());
								mis.setInsurerClaimNo(req.getInsurerClaimNo());
								Date dateAndTime;
								try {
									dateAndTime = misSerivce.combineDateAndTime(req.getDate(), req.getTime());
									mis.setDtTimeIntimation(dateAndTime);
								} catch (Exception e) {
									e.printStackTrace();
									msg = "Unable to parse Intimation Date and Time";
								}
								mis.setInsured(insd.getId());
								mis.setRepName(req.getInsureRepName());
								mis.setPolicyNo(req.getInsuredPolNo());
								mis.setEstClaimAmt(ecl.getId());
								mis.setRegBranch(rb.getId());
								mis.setMailSendToBranch(mrb.getId());
								mis.setLocationOfLoss(req.getLocOfLoss());
								mis.setDeptName(dept.getId());
								mis.setGrNO(req.getGrNo());
								mis.setInvoiceNo(req.getInvoiceNo());
								try {
									//Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getRegDate().toString());
									mis.setRegDt(req.getRegDate());
								} catch (Exception e) {
									e.printStackTrace();
									msg = "Unable to parse Registration Date";
								}
								try {
									if(req.getGrDate()!=null) {
//										Date date = new SimpleDateFormat("yyyy-MM-dd").parse();
										mis.setGrDate(req.getGrDate());	
									}
								} catch (Exception e) {
									e.printStackTrace();
									msg = "Unable to parse GR Date";
								} 
								try {
									if(req.getInvoiceDate()!=null) {
//										Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getInvoiceDate());
										mis.setInvoiceDt(req.getInvoiceDate());	
									}
									
								} catch (Exception e) {
									e.printStackTrace();
									msg = "Unable to parse Invoice Date";
								} 
								mis.setSubDept(sdept !=null ? sdept.getId():null);
								mis.setSpecialInfo(req.getSpclInst());
								mis.setUploadFile(req.getUploadFile()!=null ?req.getUploadFile().toString() : null);
								mis.setSurveyor(surv != null ? surv.getId():null);
								mis.setFieldStaff(flds != null ?flds.getId() :null);
								
								if(msg.isEmpty()) {
									
									mis = misSerivce.saveMIS(mis);	
									if(mis  == null) {
										msg = "Unable to save Claim Intimation";
									}
									
									resList.add(obj);
									resList.add(soi);
									resList.add(brkr);
									resList.add(mis);
								}
							}
							else {
								return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg ,"server error");	
							}
							
							
							
						}
						else {
							msg = "Unable to save Source Of Instruction";
						}
					}
					else {
						msg = "Unable to save Insurer Details";
					}
				}
				else{
					return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg ,"server error");	
				}
				
				return new ApiResponse<>(HttpStatus.OK.value(), "Claim Created successfully.",resList);
			}catch(Exception e) {
			e.printStackTrace();	
			return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server Problem. Contact Tech Team." ,"server error");
			}
			
			
			
		}
        
        return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), "Invalid Access" ,"invalid");
    }
	
	
	
	private String saveInsured(ClaimRequestDTO req) {
		String msg = "";
		insd = new Insured();
		Long id = req.getInsuredId()!=null && !req.getInsuredId().trim().isEmpty() ? Long.parseLong(req.getInsuredId()): null;
		insd.setId(id);
		insd.setAdd_on_policy_doc(req.getInsuredAdd());
		insd.setEmail(req.getInsuredEmail());
		if(req.getInsuredContactNo() !=null && !req.getInsuredContactNo().trim().isEmpty())
			insd.setMobile(Long.parseLong(req.getInsuredContactNo()));
		insd.setName(req.getInsuredSelected());
		try {
			insd = insdSerivce.saveInsured(insd);
		}
		catch(Exception e) {
			msg = "Unable to save Insured details";
		}
		
		return msg;
		
	}
	
	private String saveEstClaimAmt(ClaimRequestDTO req) {
		String msg = "";
		ecl = new EstimatedClaimAmt();
		Long id = req.getEstiClaimAmtId()!=null && !req.getEstiClaimAmtId().trim().isEmpty() ? Long.parseLong(req.getEstiClaimAmtId()): null;
		ecl.setId(id);
		ecl.setValue(req.getEstClaimAmtSelected());
		
		try {
			ecl = ecadSerivce.saveEstimatedClaimAmt(ecl);	
		}catch(Exception e) {
			msg = "Unable to save Estimation Claim amt.";
		}
		
		return msg;
		
	}
	
	private String saveRegBranch(ClaimRequestDTO req) {
		String msg = "";
		rb = new RegistrationBranch();
		Long id = req.getRegBranchId()!=null && !req.getRegBranchId().trim().isEmpty() ? Long.parseLong(req.getRegBranchId()): null;
		rb.setId(id);
		rb.setName(req.getRegBranchSelected());
		try {
			rb = rbSerivce.saveRegistrationBranch(rb);	
		}catch(Exception e) {
			msg ="Unable to save Registration Branch";
			
		}
		
		return msg;
		
	}
	
	private String saveMailToRegBranch(ClaimRequestDTO req) {
		String msg = "";
		mrb = new RegistrationBranch();
		Long mid = req.getMailSendToBrId()!=null && !req.getMailSendToBrId().trim().isEmpty() ? Long.parseLong(req.getMailSendToBrId()): null;
		mrb.setId(mid);
		mrb.setName(req.getMailSendToBranchSelected());
		try {
			mrb = rbSerivce.saveRegistrationBranch(mrb);	
		}catch(Exception e) {
			msg ="Unable to save Mail to Registration Branch.";
		}
		
		return msg;
		
	}
	
	private String saveDept(ClaimRequestDTO req) {
		String msg = "";
		dept = new Department();
		Long id = req.getDeptId()!=null && !req.getDeptId().trim().isEmpty() ? Long.parseLong(req.getDeptId()): null;
		dept.setId(id);
		dept.setName(req.getDeptSelected());
		try {
			dept = depSerivce.saveDepartment(dept);
			if(dept != null) {
				msg = saveSubDept(req);
			}	

		}catch(Exception e) {
			msg = "Unable to save Department";
		}
		return msg;
		
	}
	
	private String saveSubDept(ClaimRequestDTO req) {
		String msg = "";
		sdept = new SubDepartment();
		Long id = req.getSubDeptId()!=null && !req.getSubDeptId().trim().isEmpty() ? Long.parseLong(req.getSubDeptId()): null;
		sdept.setId(id);
		sdept.setDepartment(dept.getId());
		sdept.setName(req.getSubDeptSelected());
	
		try {
			sdept = sdSerivce.saveSubDepartment(sdept);	
		}catch(Exception e) {
			e.printStackTrace();
			msg = "Unable to save Sub Department information";
		}
		return msg;
		
	}
	
	
	
	private String saveSurveyor(ClaimRequestDTO req) {
		String msg = "";
		surv = new Surveyor();
		Long id = req.getSurveyorId()!=null && !req.getSurveyorId().trim().isEmpty() ? Long.parseLong(req.getSurveyorId()): null;
		surv.setId(id);
		surv.setEmail(req.getSurveyoremail());
		if(req.getSurveryorcontact() != null && !req.getSurveryorcontact().trim().isEmpty()) {
			surv.setMobile(Long.parseLong(req.getSurveryorcontact()));	
		}
		
		surv.setName(req.getSurveyorSelected());
		try {
			surv = surSerivce.saveSurveyor(surv);	
		}catch(Exception e) {
			msg = "Unable to save Surveyor";
		}
		
		return msg;
		
	}
	
	
	private String saveFieldStaff(ClaimRequestDTO req) {
		String msg = "";
		flds = new FieldStaff();
		Long id = req.getFieldStaffId()!=null && !req.getFieldStaffId().trim().isEmpty() ? Long.parseLong(req.getFieldStaffId()): null;
		flds.setId(id);
		flds.setEmail(req.getFieldStaffemail());
		if(req.getFeildStaffContact() !=null && !req.getFeildStaffContact().trim().isEmpty()) {
			flds.setMobile(Long.parseLong(req.getFeildStaffContact()));
		}
		
		flds.setName(req.getFieldStaffSelected());
		try {
			flds = fsSerivce.saveFieldStaff(flds);	
		}
		catch(Exception e) {
			msg = "Unable to save field staff";
		}
		
		return msg;
		
	}
	

}
