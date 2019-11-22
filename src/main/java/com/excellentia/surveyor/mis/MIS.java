package com.excellentia.surveyor.mis;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "mis")
public class MIS {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "job_no")
	String jobNo;
	
	@Column(name = "insurer")
	Long insurer;
	
	@Column(name = "insured")
	Long insured;
	
	@Column(name = "surveyor")
	Long surveyor;
	
	@Column(name = "field_staff")
	Long fieldStaff;
	
	@Column(name = "dt_of_survey")
	Date dtOfSurvey;
	
	@Column(name = "dt_of_ILA")
	Date dtOfILA;
	
	@Column(name = "dt_of_LOR")
	Date dtOfLOR;
	
	@Column(name = "dt_of_FSR")
	Date dtOfFSR;
	
	@Column(name = "status")
	Long status;
	
	@Column(name = "last_comm_date")
	Date lastCommuDt;
	
	@Column(name = "ILA_TAT")
	Long ilaTAT;
	
	@Column(name = "FSR_TAT")
	Long fsrTAT;
	
	@Column(name = "ageing")
	Long ageing;
	
	@Column(name = "loss_reserve")
	BigInteger lossReserve;
	
	@Column(name = "revised_loss_reserve")
	BigInteger revisedLossReserve;
	
	
	
	@Column(name = "broker")
	Long broker;
	
	@Column(name = "dt_time_intimation")
	Date dtTimeIntimation;
	
	@Column(name = "insurer_claim_no")
	String insurerClaimNo;
	
	
	@Column(name = "location_of_loss")
	String locationOfLoss;
	
	@Column(name = "dept_name")
	Long deptName;
	
	@Column(name = "sub_dept")
	Long subDept;
	
	@Column(name = "GR_NO")
	String grNO;
	
	@Column(name = "GR_DATE")
	Date grDate;
	
	@Column(name = "est_claim_amt")
	Long estClaimAmt;
	
	@Column(name = "reg_branch")
	Long regBranch;
	
	@Column(name = "mail_send_to_branch")
	Long mailSendToBranch;
	
	@Column(name = "rep_name")
	String repName;
	
	@Column(name = "policy_no")
	String policyNo;
	
	@Column(name = "invoice_no")
	String invoiceNo;
	
	@Column(name = "invoice_dt")
	Date invoiceDt;
	
	@Column(name = "reg_dt")
	Date regDt;
	
	@Column(name = "special_info")
	String specialInfo;
	
	@Column(name = "upload_file")
	String uploadFile;
	
	@Column(name = "date_of_loss")
	Date dtOfLoss;
	
	@Column(name = "src_of_inst")
	Long srcOfInst;
	
	@Transient
	String insType;
	
	@Transient
	String srcOfInstName;
	
	@Transient
	String insuredName;
	
	@Transient
	String insuredContact;
	
	@Transient
	String estClaimAmtValue;
	
	@Transient
	String deptNameVal;
	
	
	
	public String getSrcOfInstName() {
		return srcOfInstName;
	}
	public void setSrcOfInstName(String srcOfInstName) {
		this.srcOfInstName = srcOfInstName;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredContact() {
		return insuredContact;
	}
	public void setInsuredContact(String insuredContact) {
		this.insuredContact = insuredContact;
	}
	public String getEstClaimAmtValue() {
		return estClaimAmtValue;
	}
	public void setEstClaimAmtValue(String estClaimAmtValue) {
		this.estClaimAmtValue = estClaimAmtValue;
	}
	public String getDeptNameVal() {
		return deptNameVal;
	}
	public void setDeptNameVal(String deptNameVal) {
		this.deptNameVal = deptNameVal;
	}
	public String getInsType() {
		return insType;
	}
	public void setInsType(String insType) {
		this.insType = insType;
	}
	public Long getFieldStaff() {
		return fieldStaff;
	}
	public void setFieldStaff(Long fieldStaff) {
		this.fieldStaff = fieldStaff;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public Long getInsurer() {
		return insurer;
	}
	public void setInsurer(Long insurer) {
		this.insurer = insurer;
	}
	public Long getInsured() {
		return insured;
	}
	public void setInsured(Long insured) {
		this.insured = insured;
	}
	public Long getSurveyor() {
		return surveyor;
	}
	public void setSurveyor(Long surveyor) {
		this.surveyor = surveyor;
	}
	public Date getDtOfSurvey() {
		return dtOfSurvey;
	}
	public void setDtOfSurvey(Date dtOfSurvey) {
		this.dtOfSurvey = dtOfSurvey;
	}
	public Date getDtOfILA() {
		return dtOfILA;
	}
	public void setDtOfILA(Date dtOfILA) {
		this.dtOfILA = dtOfILA;
	}
	public Date getDtOfLOR() {
		return dtOfLOR;
	}
	public void setDtOfLOR(Date dtOfLOR) {
		this.dtOfLOR = dtOfLOR;
	}
	public Date getDtOfFSR() {
		return dtOfFSR;
	}
	public void setDtOfFSR(Date dtOfFSR) {
		this.dtOfFSR = dtOfFSR;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Date getLastCommuDt() {
		return lastCommuDt;
	}
	public void setLastCommuDt(Date lastCommuDt) {
		this.lastCommuDt = lastCommuDt;
	}
	public Long getIlaTAT() {
		return ilaTAT;
	}
	public void setIlaTAT(Long ilaTAT) {
		this.ilaTAT = ilaTAT;
	}
	public Long getFsrTAT() {
		return fsrTAT;
	}
	public void setFsrTAT(Long fsrTAT) {
		this.fsrTAT = fsrTAT;
	}
	public Long getAgeing() {
		return ageing;
	}
	public void setAgeing(Long ageing) {
		this.ageing = ageing;
	}
	public BigInteger getLossReserve() {
		return lossReserve;
	}
	public void setLossReserve(BigInteger lossReserve) {
		this.lossReserve = lossReserve;
	}
	public BigInteger getRevisedLossReserve() {
		return revisedLossReserve;
	}
	public void setRevisedLossReserve(BigInteger revisedLossReserve) {
		this.revisedLossReserve = revisedLossReserve;
	}

	public Long getBroker() {
		return broker;
	}
	public void setBroker(Long broker) {
		this.broker = broker;
	}
	public Date getDtTimeIntimation() {
		return dtTimeIntimation;
	}
	public void setDtTimeIntimation(Date dtTimeIntimation) {
		this.dtTimeIntimation = dtTimeIntimation;
	}
	public String getInsurerClaimNo() {
		return insurerClaimNo;
	}
	public void setInsurerClaimNo(String insurerClaimNo) {
		this.insurerClaimNo = insurerClaimNo;
	}
	public String getLocationOfLoss() {
		return locationOfLoss;
	}
	public void setLocationOfLoss(String locationOfLoss) {
		this.locationOfLoss = locationOfLoss;
	}
	public Long getDeptName() {
		return deptName;
	}
	public void setDeptName(Long deptName) {
		this.deptName = deptName;
	}
	public Long getSubDept() {
		return subDept;
	}
	public void setSubDept(Long subDept) {
		this.subDept = subDept;
	}
	public String getGrNO() {
		return grNO;
	}
	public void setGrNO(String grNO) {
		this.grNO = grNO;
	}
	public Date getGrDate() {
		return grDate;
	}
	public void setGrDate(Date grDate) {
		this.grDate = grDate;
	}
	
	public Long getEstClaimAmt() {
		return estClaimAmt;
	}
	public void setEstClaimAmt(Long estClaimAmt) {
		this.estClaimAmt = estClaimAmt;
	}
	public Long getRegBranch() {
		return regBranch;
	}
	public void setRegBranch(Long regBranch) {
		this.regBranch = regBranch;
	}
	public Long getMailSendToBranch() {
		return mailSendToBranch;
	}
	public void setMailSendToBranch(Long mailSendToBranch) {
		this.mailSendToBranch = mailSendToBranch;
	}
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Date getInvoiceDt() {
		return invoiceDt;
	}
	public void setInvoiceDt(Date invoiceDt) {
		this.invoiceDt = invoiceDt;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getSpecialInfo() {
		return specialInfo;
	}
	public void setSpecialInfo(String specialInfo) {
		this.specialInfo = specialInfo;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public Date getDtOfLoss() {
		return dtOfLoss;
	}
	public void setDtOfLoss(Date dtOfLoss) {
		this.dtOfLoss = dtOfLoss;
	}
	public Long getSrcOfInst() {
		return srcOfInst;
	}
	public void setSrcOfInst(Long srcOfInst) {
		this.srcOfInst = srcOfInst;
	}
	
	
	
	

}
