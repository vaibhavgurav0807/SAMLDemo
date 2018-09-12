package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entities.User;

//@Controller
@RestController
public class IndexController{
	
	@Autowired
	private UserDao userDao;
	
    //@RequestMapping("/")
    @GetMapping("/")
	public User index() {
    	SAMLCredential cre= (SAMLCredential) SecurityContextHolder.getContext().getAuthentication().getCredentials();
    	System.out.println(cre.getAttributeAsString("username"));
    	
    	String userName=cre.getAttributeAsString("username");
    	User user= userDao.findByLoginId(userName);
    	System.out.println("User Details Are: ");
    	System.out.println(user.toString());
    	return user;
      }
	
}