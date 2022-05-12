package com.springboot.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "userId")
	private int uId;
	@Column(name = "userName")
	private String uName;
	@Column(name = "userWork")
	private String uWork;
	@Column(name = "userAge")
	private int uAge;
	@Transient
	private List<Address> uAddress;
	
	public User() {
		super();
	}
	public User(int uId, String uName, String uWork, int uAge) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uWork = uWork;
		this.uAge = uAge;
	}
	public User(int uId, String uName, String uWork, int uAge, List<Address> uAddress) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uWork = uWork;
		this.uAge = uAge;
		this.uAddress = uAddress;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuWork() {
		return uWork;
	}
	public void setuWork(String uWork) {
		this.uWork = uWork;
	}
	public int getuAge() {
		return uAge;
	}
	public void setuAge(int uAge) {
		this.uAge = uAge;
	}
	public List<Address> getuAddress() {
		return uAddress;
	}
	public void setuAddress(List<Address> uAddress) {
		this.uAddress = uAddress;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uWork=" + uWork + ", uAge=" + uAge + ", uAddress="
				+ uAddress + "]";
	}
}
