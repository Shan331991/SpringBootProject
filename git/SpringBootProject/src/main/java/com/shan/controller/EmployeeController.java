package com.shan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shan.common.Combine;
import com.shan.dao.EmployeeDao;
import com.shan.dao.UserDao;
import com.shan.model.Employee;
import com.shan.model.User;
import com.shan.service.EmployeeService;
import com.shan.service.UserService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired(required = true)
	private EmployeeService employeeService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmployee() {
		return employeeService.findAll();
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public void create(@RequestBody Combine combine) {
		
		User user = new User();
		user.setId(combine.getId());
		user.setUsername(combine.getUsername());
		user.setPassword(combine.getPassword());
		user.setEmail(combine.getEmail());
			
		Employee emp = new Employee();
		emp.setId(combine.getId());
		emp.setEmail(combine.getEmail());
		emp.setFname(combine.getFname());
		emp.setLname(combine.getLname());
		emp.setDesignation(combine.getDesignation());
		emp.setJoining_date(combine.getJoining_date());
		
		employeeService.save(emp);
		userService.save(user);
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long Id) {
		employeeService.delete(Id);
		return "success";
	}

}
