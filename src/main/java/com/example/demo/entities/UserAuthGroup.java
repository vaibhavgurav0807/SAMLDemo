package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Table(name="user_auth_group")
public class UserAuthGroup {	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userAuthGroupId;
	
	//@JsonBackReference
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="auth_group_id", nullable= false)
	private AuthGroup authGroup;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="user_id", nullable= false)
	private User user;

	public Integer getUserAuthGroupId() {
		return userAuthGroupId;
	}

	public void setUserAuthGroupId(Integer userAuthGroup) {
		this.userAuthGroupId = userAuthGroup;
	}

	public AuthGroup getAuthGroup() {
		return authGroup;
	}

	public void setAuthGroup(AuthGroup authGroup) {
		this.authGroup = authGroup;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAuthGroup [userAuthGroupId=" + userAuthGroupId + ", authGroup=" + authGroup.toString() + "]";
	}
}
