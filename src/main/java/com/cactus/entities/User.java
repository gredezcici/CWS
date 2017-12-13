package com.cactus.entities;

import java.util.Date;

public class User {
	private String id;
	private String lastname;
	private String firstname;
	private String loginname;
	private int phone;
	private String email;
	private String wechat_account;
	private String address;
	private int age;
	private Date birthDay;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getWechat_account() {
		return wechat_account;
	}

	public void setWechat_account(String wechat_account) {
		this.wechat_account = wechat_account;
	}

	private String group;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechatAccount() {
		return wechat_account;
	}

	public void setWechatAccount(String wechatAccount) {
		this.wechat_account = wechatAccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
}
