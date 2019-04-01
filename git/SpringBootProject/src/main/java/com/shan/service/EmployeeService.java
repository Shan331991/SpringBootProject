package com.shan.service;

import java.util.List;

import com.shan.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	List<Employee> findAll();
	void delete(long Id);
	
}