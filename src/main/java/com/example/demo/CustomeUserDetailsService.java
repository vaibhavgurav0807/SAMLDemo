package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entities.User;

//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;


@Service
public class CustomeUserDetailsService implements SAMLUserDetailsService {
	
	//private JdbcDaoImpl jdbcUserService;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
		String userName = credential.getAttributeAsString("username");
		UserDetails user = null;
		
		try {
			User userJdbc = userDao.findByLoginId(userName);
			System.out.println(userJdbc.toString());
        } catch (UsernameNotFoundException e) {
            System.out.println("User not found in DB");            
        }
        return user;
			    /*    
			String userID = credential.getNameID().getValue();
					
					LOG.info(userID + " is logged in");
					List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
					GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
					authorities.add(authority);
			
					// In a real scenario, this implementation has to locate user in a arbitrary
					// dataStore based on information present in the SAMLCredential and
					// returns such a date in a form of application specific UserDetails object.
			return new User(userID, "<abc123>", true, true, true, true, authorities);*/
        
    }
	
}
	