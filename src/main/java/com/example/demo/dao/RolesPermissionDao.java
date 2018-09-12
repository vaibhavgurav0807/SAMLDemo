package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.RolesPermission;
@Repository
public interface RolesPermissionDao extends CrudRepository<RolesPermission,Integer>{

}
