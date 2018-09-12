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
@Table(name="role_permission")
public class RolesPermission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolePermissionId;
	
	//@JsonBackReference
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="permission_id", nullable= false)
	private Permission permission;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="role_id", nullable= false)
	private Roles roles;
	
	
	public Integer getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "RolesPermission [rolePermissionId=" + rolePermissionId + ", permission=" + permission.toString() + "]";
	}
		
}
