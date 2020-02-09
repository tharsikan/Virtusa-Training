package com.ishan.app.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.app.model.Employee;
import com.ishan.app.service.EmployeeService;

@RestController
@RequestMapping("service")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("test")
	public String test() {
		return "okkkk";
	}

	@Transactional
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee getEmployees(@RequestBody Employee e) {

		Employee eee = employeeService.save(e);
		return eee;
	}
}
