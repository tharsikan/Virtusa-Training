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
import com.ishan.app.repository.EmployeeRepository;
import com.ishan.app.service.EmployeeService;

//Declare this class as Rest controller class
@RestController
@RequestMapping("service")
public class EmployeeController {
	// Service bean has been made so autowire it to out reference
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("test")
	public String test() {
		return "okkkk";
	}

	//findThe selected element  and return so this is done by JpaRepository find method
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		if (id == 0) {
			Employee employee = new Employee();
			employee.setId(10);
			employee.setName("ishan");
			return employee;
		} else
			return employeeService.findById(id);

	}

	@Transactional
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee getEmployees(@RequestBody Employee e) {

		Employee eee = employeeService.save(e);
		return eee;
	}
}
