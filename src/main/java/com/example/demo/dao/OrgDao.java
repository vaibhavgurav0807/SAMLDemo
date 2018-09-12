package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Org;

@Repository
public interface OrgDao extends CrudRepository<Org,Integer>{

}
