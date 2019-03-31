package com.shan.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shan.dao.UserDao;
import com.shan.model.User;

@Service(value="userService")
public class UserServiceImpl implements UserDetailsService, UserService{

	
	@Autowired
	private UserDao userDAO;
	
	@Override
	public User save(User user) {
		
		return userDAO.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDAO.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDAO.delete(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user=userDAO.findByUsername(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username/password");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getUsername()),user.getPassword(),getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority(){
		return Arrays.asList(new SimpleGrantedAuthority("role_admin"));
	}

	}
