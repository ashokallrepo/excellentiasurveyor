package com.excellentia.surveyor.insured;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "insured")
public class Insured {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "country")
	String country;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state")
	String state;
	
	@Column(name = "pincode")
	String pincode;
	
	@Column(name = "add_on_policy_doc")
	String add_on_policy_doc;
	
	@Column(name = "mobile")
	Long mobile;
	
	@Column(name = "email")
	String email;
	
	
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	public String getAdd_on_policy_doc() {
		return add_on_policy_doc;
	}
	public void setAdd_on_policy_doc(String add_on_policy_doc) {
		this.add_on_policy_doc = add_on_policy_doc;
	}

	
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
