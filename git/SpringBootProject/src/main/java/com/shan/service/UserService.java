package com.shan.service;

import java.util.List;

import com.shan.model.User;

public interface UserService {

	User save(User user);
	List<User> findAll();
	void delete(long id);
	
}

