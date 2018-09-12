package com.example.demo.entities;

import java.util.ArrayList;
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
@Table(name="org")
public class Org {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orgId;
	
	@Column(name="org_name")
	private String orgName;
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="org")
	private List<User> user= new ArrayList<User>(0);

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Org [orgId=" + orgId + ", orgName=" + orgName + "]";
	}
	
	
}
