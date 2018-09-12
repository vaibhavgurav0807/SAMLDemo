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
@Table(name="user_role")
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleId;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="user_id", nullable= false)
	private User user;
	
	//@JsonBackReference
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="role_id", nullable= false)
	private Roles roles;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserRoles [userRoleId=" + userRoleId + ", roles=" + roles.toString() + "]";
	}
}
