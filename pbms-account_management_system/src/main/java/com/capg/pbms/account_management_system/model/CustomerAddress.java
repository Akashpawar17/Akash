package com.capg.pbms.account_management_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
* CustomerAddress Bean class
*
* @author   :P.Akshitha, J.PavanKumar
* @version  :1.0
* @since    :2020-08-15
*/

@Entity
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addId;
	private String customerAddress1;
	private String customerAddress2;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerAddress(int addId, String customerAddress1, String customerAddress2, String city, String state,
			String country, int pincode) {
		super();
		this.addId = addId;
		this.customerAddress1 = customerAddress1;
		this.customerAddress2 = customerAddress2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "CustomerAddress [customerAddress1=" + customerAddress1 + ", customerAddress2=" + customerAddress2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getCustomerAddress1() {
		return customerAddress1;
	}
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}
	public String getCustomerAddress2() {
		return customerAddress2;
	}
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
