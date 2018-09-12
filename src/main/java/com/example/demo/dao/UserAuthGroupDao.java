package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserAuthGroup;

@Repository
public interface UserAuthGroupDao extends CrudRepository<UserAuthGroup,Integer>{

}
