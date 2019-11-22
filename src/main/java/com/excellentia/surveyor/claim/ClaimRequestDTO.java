package com.excellentia.surveyor.claim;

import java.util.Date;

public class ClaimRequestDTO {
	
	String jobNo;
	Long misid;
	
	String id;
	String gst;
	String insurerClaimNo;
	String email;
	String add;
	String contactNo;
	String name;
	String date;
	String time;
	String brokerSelected;
	String insurerSelected;
	String stateSelected;
	String srcOfInsSelected;
	Long brokerId;
	Long srcOfInsId;
	String typeSelected;
	
	
	//for insured ---------
	String insuredId;
	String insuredSelected;
	String estClaimAmtSelected;
	String estiClaimAmtId;
	String regBranchSelected;
	String regBranchId;
	String mailSendToBranchSelected;
	String mailSendToBrId;
	String deptSelected;
	String deptId;
	String subDeptSelected;
	String subDeptId;
	String insuredContactNo;
	String insuredEmail;
	String insuredAdd;
	String insureRepName;
	String insuredPolNo;
	String locOfLoss;
	String grNo;
	Date grDate;
	String invoiceNo;
	Date invoiceDate;
	Date regDate;
	String spclInst;
    Object uploadFile;
    
    
    String surveyorSelected;
    String surveyorId;
    String surveyoremail;
    String surveryorcontact;
    String fieldStaffSelected;
    String fieldStaffemail;
    String feildStaffContact;
    String fieldStaffId;
	
	String token;
	

	
	
	
	public Long getMisid() {
		return misid;
	}



	public void setMisid(Long misid) {
		this.misid = misid;
	}



	public String getTypeSelected() {
		return typeSelected;
	}



	public void setTypeSelected(String typeSelected) {
		this.typeSelected = typeSelected;
	}



	public String getJobNo() {
		return jobNo;
	}



	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}



	public String getSurveyorSelected() {
		return surveyorSelected;
	}
	public void setSurveyorSelected(String surveyorSelected) {
		this.surveyorSelected = surveyorSelected;
	}
	public String getSurveyorId() {
		return surveyorId;
	}
	public void setSurveyorId(String surveyorId) {
		this.surveyorId = surveyorId;
	}
	public String getSurveyoremail() {
		return surveyoremail;
	}
	public void setSurveyoremail(String surveyoremail) {
		this.surveyoremail = surveyoremail;
	}
	public String getSurveryorcontact() {
		return surveryorcontact;
	}
	public void setSurveryorcontact(String surveryorcontact) {
		this.surveryorcontact = surveryorcontact;
	}
	public String getFieldStaffSelected() {
		return fieldStaffSelected;
	}
	public void setFieldStaffSelected(String fieldStaffSelected) {
		this.fieldStaffSelected = fieldStaffSelected;
	}
	public String getFieldStaffemail() {
		return fieldStaffemail;
	}
	public void setFieldStaffemail(String fieldStaffemail) {
		this.fieldStaffemail = fieldStaffemail;
	}
	public String getFeildStaffContact() {
		return feildStaffContact;
	}
	public void setFeildStaffContact(String feildStaffContact) {
		this.feildStaffContact = feildStaffContact;
	}
	public String getFieldStaffId() {
		return fieldStaffId;
	}
	public void setFieldStaffId(String fieldStaffId) {
		this.fieldStaffId = fieldStaffId;
	}
	public Long getSrcOfInsId() {
		return srcOfInsId;
	}
	public void setSrcOfInsId(Long srcOfInsId) {
		this.srcOfInsId = srcOfInsId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getInsurerClaimNo() {
		return insurerClaimNo;
	}
	public void setInsurerClaimNo(String insurerClaimNo) {
		this.insurerClaimNo = insurerClaimNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBrokerSelected() {
		return brokerSelected;
	}
	public void setBrokerSelected(String brokerSelected) {
		this.brokerSelected = brokerSelected;
	}
	public String getInsurerSelected() {
		return insurerSelected;
	}
	public void setInsurerSelected(String insurerSelected) {
		this.insurerSelected = insurerSelected;
	}
	public String getStateSelected() {
		return stateSelected;
	}
	public void setStateSelected(String stateSelected) {
		this.stateSelected = stateSelected;
	}
	public String getSrcOfInsSelected() {
		return srcOfInsSelected;
	}
	public void setSrcOfInsSelected(String srcOfInsSelected) {
		this.srcOfInsSelected = srcOfInsSelected;
	}
	public Long getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}
	public String getInsuredId() {
		return insuredId;
	}
	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}
	public String getInsuredSelected() {
		return insuredSelected;
	}
	public void setInsuredSelected(String insuredSelected) {
		this.insuredSelected = insuredSelected;
	}
	public String getEstClaimAmtSelected() {
		return estClaimAmtSelected;
	}
	public void setEstClaimAmtSelected(String estClaimAmtSelected) {
		this.estClaimAmtSelected = estClaimAmtSelected;
	}
	public String getEstiClaimAmtId() {
		return estiClaimAmtId;
	}
	public void setEstiClaimAmtId(String estiClaimAmtId) {
		this.estiClaimAmtId = estiClaimAmtId;
	}
	public String getRegBranchSelected() {
		return regBranchSelected;
	}
	public void setRegBranchSelected(String regBranchSelected) {
		this.regBranchSelected = regBranchSelected;
	}
	public String getRegBranchId() {
		return regBranchId;
	}
	public void setRegBranchId(String regBranchId) {
		this.regBranchId = regBranchId;
	}
	public String getMailSendToBranchSelected() {
		return mailSendToBranchSelected;
	}
	public void setMailSendToBranchSelected(String mailSendToBranchSelected) {
		this.mailSendToBranchSelected = mailSendToBranchSelected;
	}
	public String getMailSendToBrId() {
		return mailSendToBrId;
	}
	public void setMailSendToBrId(String mailSendToBrId) {
		this.mailSendToBrId = mailSendToBrId;
	}
	public String getDeptSelected() {
		return deptSelected;
	}
	public void setDeptSelected(String deptSelected) {
		this.deptSelected = deptSelected;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getSubDeptSelected() {
		return subDeptSelected;
	}
	public void setSubDeptSelected(String subDeptSelected) {
		this.subDeptSelected = subDeptSelected;
	}
	public String getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(String subDeptId) {
		this.subDeptId = subDeptId;
	}
	public String getInsuredContactNo() {
		return insuredContactNo;
	}
	public void setInsuredContactNo(String insuredContactNo) {
		this.insuredContactNo = insuredContactNo;
	}
	public String getInsuredEmail() {
		return insuredEmail;
	}
	public void setInsuredEmail(String insuredEmail) {
		this.insuredEmail = insuredEmail;
	}
	public String getInsuredAdd() {
		return insuredAdd;
	}
	public void setInsuredAdd(String insuredAdd) {
		this.insuredAdd = insuredAdd;
	}
	public String getInsureRepName() {
		return insureRepName;
	}
	public void setInsureRepName(String insureRepName) {
		this.insureRepName = insureRepName;
	}
	public String getInsuredPolNo() {
		return insuredPolNo;
	}
	public void setInsuredPolNo(String insuredPolNo) {
		this.insuredPolNo = insuredPolNo;
	}
	public String getLocOfLoss() {
		return locOfLoss;
	}
	public void setLocOfLoss(String locOfLoss) {
		this.locOfLoss = locOfLoss;
	}
	public String getGrNo() {
		return grNo;
	}
	public void setGrNo(String grNo) {
		this.grNo = grNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	
	public Date getGrDate() {
		return grDate;
	}



	public void setGrDate(Date grDate) {
		this.grDate = grDate;
	}



	public Date getInvoiceDate() {
		return invoiceDate;
	}



	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getSpclInst() {
		return spclInst;
	}
	public void setSpclInst(String spclInst) {
		this.spclInst = spclInst;
	}
	public Object getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(Object uploadFile) {
		this.uploadFile = uploadFile;
	}



	@Override
	public String toString() {
		return "ClaimRequestDTO [jobNo=" + jobNo + ", misid=" + misid + ", id=" + id + ", gst=" + gst
				+ ", insurerClaimNo=" + insurerClaimNo + ", email=" + email + ", add=" + add
				+ ", contactNo=" + contactNo + ", name=" + name + ", date=" + date + ", time=" + time
				+ ", brokerSelected=" + brokerSelected + ", insurerSelected=" + insurerSelected + ", stateSelected="
				+ stateSelected + ", srcOfInsSelected=" + srcOfInsSelected
				+ ", brokerId=" + brokerId + ", srcOfInsId=" + srcOfInsId + ", typeSelected=" + typeSelected
				+ ", insuredId=" + insuredId + ", insuredSelected=" + insuredSelected + ", estClaimAmtSelected="
				+ estClaimAmtSelected + ", estiClaimAmtId=" + estiClaimAmtId + ", regBranchSelected="
				+ regBranchSelected + ", regBranchId=" + regBranchId + ", mailSendToBranchSelected="
				+ mailSendToBranchSelected + ", mailSendToBrId=" + mailSendToBrId + ", deptSelected=" + deptSelected
				+ ", deptId=" + deptId + ", subDeptSelected=" + subDeptSelected + ", subDeptId=" + subDeptId
				+ ", insuredContactNo=" + insuredContactNo + ", insuredEmail=" + insuredEmail + ", insuredAdd="
				+ insuredAdd + ", insureRepName=" + insureRepName
				+ ", insuredPolNo=" + insuredPolNo + ", locOfLoss=" + locOfLoss + ", grNo=" + grNo + ", grDate="
				+ grDate + ", invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate + ", regDate=" + regDate
				+ ", spclInst=" + spclInst + ", uploadFile=" + uploadFile + ", surveyorSelected=" + surveyorSelected
				+ ", surveyorId=" + surveyorId + ", surveyoremail=" + surveyoremail + ", surveryorcontact="
				+ surveryorcontact + ", fieldStaffSelected=" + fieldStaffSelected + ", fieldStaffemail="
				+ fieldStaffemail + ", feildStaffContact=" + feildStaffContact + ", fieldStaffId=" + fieldStaffId
				+ ", token=" + token + "]";
	}
	
	
	
	
	


}
