package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	public User findByLoginId(String userName);

	/*@Query(value="select role from UserRole user where user.username =:username")
	public String[] getRole(@Param("username") String username);*/
}
