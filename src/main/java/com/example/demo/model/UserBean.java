package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Currency;
@Entity
public class UserBean {
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 1, max = 20)
	private String name;
	private int age;
//	@Currency(value = { "INR" })
	private BigDecimal salary;
public UserBean() {
		
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public UserBean(int id, String name, int age, BigDecimal salary) {
		
		this.name = name;
		this.age = age;
		this.salary = salary;
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
		return "UserBean [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
