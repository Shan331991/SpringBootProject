package com.shan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shan.model.Employee;
import com.shan.dao.*;


@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeDao employeeDAO;
	
	@Override
	public Employee save(Employee employee) {
		
		return employeeDAO.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		employeeDAO.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public void delete(long id) {
		employeeDAO.delete(id);
		
	}
	}
