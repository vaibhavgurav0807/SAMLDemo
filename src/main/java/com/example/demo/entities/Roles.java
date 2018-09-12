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
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="application_name")
	private String applicationName;
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch= FetchType.LAZY, mappedBy="roles")
	private List<UserRoles> userRoles;
	
	//@JsonManagedReference
	@OneToMany(fetch= FetchType.LAZY, mappedBy="roles")
	private List<RolesPermission> rolesPermission;

	public List<RolesPermission> getRolesPermission() {
		return rolesPermission;
	}

	public void setRolesPermission(List<RolesPermission> rolesPermission) {
		this.rolesPermission = rolesPermission;
	}

	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + ", applicationName=" + applicationName
				+ ", rolesPermission=" + rolesPermission.toString() + "]";
	}
}
