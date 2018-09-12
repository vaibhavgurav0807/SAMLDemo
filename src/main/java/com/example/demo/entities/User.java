package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name="first_name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="login_id")
	private String loginId;
	
	//@JsonBackReference
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="org_id", nullable= false)
	private Org org;
	
	//@JsonManagedReference
	@OneToMany(fetch= FetchType.LAZY, mappedBy="user")
	private List<UserRoles> userRoles;
	
	//@JsonManagedReference
	@OneToMany(fetch= FetchType.LAZY, mappedBy="user")
	private List<UserAuthGroup> userAuthGroup;
	
	public List<UserAuthGroup> getUserAuthGroup() {
		return userAuthGroup;
	}

	public void setUserAuthGroup(List<UserAuthGroup> userAuthGroup) {
		this.userAuthGroup = userAuthGroup;
	}

	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	@Column(name="user_type")
	private String userType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", loginId=" + loginId
				+ ", org=" + org.toString() + ", userRoles=" + userRoles.toString() + ", userType=" + userType + ", userAuthGroup="
				+ userAuthGroup.toString() + "]";
	}
	
}
