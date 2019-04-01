package com.shan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shan.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	User findById(long id);
	User findByUsername(String userName);

}
