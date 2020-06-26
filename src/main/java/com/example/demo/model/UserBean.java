package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Currency;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@ApiModel(description="All details about bean")

public class UserBean {
	@Id
	@GeneratedValue
	private int id;
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	@Size(min = 1, max = 20)
	private String name;
	@JsonIgnore
	private String cardinfo;
	private int age;
//	@Currency(value = { "INR" })
	private BigDecimal salary;
	@Embedded
	private AddressBean address;
	public UserBean() {
		super();
		this.id = id;
		this.name = name;
		this.cardinfo = cardinfo;
		this.age = age;
		this.salary = salary;
		this.address=address;
	}
	
	public UserBean(int id, @Size(min = 1, max = 20) String name, String cardinfo, int age, BigDecimal salary) {
	super();
	this.id = id;
	this.name = name;
	this.cardinfo = cardinfo;
	this.age = age;
	this.salary = salary;
	this.address=address;
}
	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardinfo() {
		return cardinfo;
	}
	public void setCardinfo(String cardinfo) {
		this.cardinfo = cardinfo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", cardinfo=" + cardinfo + ", age=" + age + ", salary="
				+ salary + ", address=" + address + "]";
	}

	
	
	

}
