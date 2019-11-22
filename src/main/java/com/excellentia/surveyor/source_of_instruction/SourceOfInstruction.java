package com.excellentia.surveyor.source_of_instruction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "source_of_instruction")
public class SourceOfInstruction {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "pincode")
	Long pincode;
	
	@Column(name = "address")
	String address;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "contact_no")
	String contactNo;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "office_code_ro_do")
	String officeCodeRoDo;
	
	@Column(name = "insurer")
	Long insurer;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOfficeCodeRoDo() {
		return officeCodeRoDo;
	}
	public void setOfficeCodeRoDo(String officeCodeRoDo) {
		this.officeCodeRoDo = officeCodeRoDo;
	}
	public Long getInsurer() {
		return insurer;
	}
	public void setInsurer(Long insurer) {
		this.insurer = insurer;
	}
	
	
	
	
	

}
