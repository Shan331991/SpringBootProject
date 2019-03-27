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

import com.shan.dao.EmployeeDao;
import com.shan.model.Employee;


@Service(value="employeeService")
public class EmployeeServiceImpl implements UserDetailsService, EmployeeService{

	
	@Autowired
	private EmployeeDao employeeDAO;
	
	public Employee save(Employee employee) {
		
		return employeeDAO.save(employee);
	}


	@Override
	public UserDetails loadUserByUsername(String empName) throws UsernameNotFoundException {
		Employee employee=employeeDAO.findByfname(empName);
		
		if(employee == null) {
			throw new UsernameNotFoundException("Invalid username/password");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(employee.getId()),employee.getfname(),getAuthority());
		
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		employeeDAO.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long empId) {
		employeeDAO.delete(empId);
		
	}

	private List<SimpleGrantedAuthority> getAuthority(){
		return Arrays.asList(new SimpleGrantedAuthority("role_admin"));
	}

	}
