package com.example.demo.model;

import javax.persistence.Embeddable;
@Embeddable
public class AddressBean {
	private  int houseno;
	private String lane;
	private String zipcode;
	public AddressBean() {
		
		this.houseno = houseno;
		this.lane = lane;
		this.zipcode = zipcode;
	}
	
	public AddressBean(int houseno, String lane, String zipcode) {
		
		this.houseno = houseno;
		this.lane = lane;
		this.zipcode = zipcode;
	}
	
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	

}
