package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Table(name="auth_group")
public class AuthGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authGroupId;
	
	@Column(name="auth_group_type")
	private String authGroupType;
	
	@Column(name="access_area")
	private String accessArea;

	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch= FetchType.LAZY, mappedBy="authGroup")
	private List<UserAuthGroup> userAuthGroup;
	
	public List<UserAuthGroup> getUserAuthGroup() {
		return userAuthGroup;
	}

	public void setUserAuthGroup(List<UserAuthGroup> userAuthGroup) {
		this.userAuthGroup = userAuthGroup;
	}

	public Integer getAuthGroupId() {
		return authGroupId;
	}

	public void setAuthGroupId(Integer authGroupId) {
		this.authGroupId = authGroupId;
	}

	public String getAuthGroupType() {
		return authGroupType;
	}

	public void setAuthGroupType(String authGroupType) {
		this.authGroupType = authGroupType;
	}

	public String getAccessArea() {
		return accessArea;
	}

	public void setAccessArea(String accessArea) {
		this.accessArea = accessArea;
	}

	@Override
	public String toString() {
		return "AuthGroup [authGroupId=" + authGroupId + ", authGroupType=" + authGroupType + ", accessArea="
				+ accessArea + "]";
	}
}
