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
@Table(name="permission")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permission_id;
	
	@Column(name="permission")
	private String permission;
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch= FetchType.LAZY, mappedBy="permission")
	private List<RolesPermission> rolesPermission;

	public List<RolesPermission> getRolesPermission() {
		return rolesPermission;
	}

	public void setRolesPermission(List<RolesPermission> rolesPermission) {
		this.rolesPermission = rolesPermission;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Permission [permission_id=" + permission_id + ", permission=" + permission + "]";
	}
}
