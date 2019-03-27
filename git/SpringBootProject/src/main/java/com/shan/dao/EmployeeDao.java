package com.shan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shan.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{
	Employee findByfname(String fname);

}
