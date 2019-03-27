package com.shan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shan.model.Employee;
import com.shan.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired(required=true)
    private EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/emp/{Id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "Id") Long Id) {
        employeeService.delete(Id);
        return "success";
    }

}
