package com.krishantha.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepository employeeRepository;

	// no ars cons
	public EmployeeServiceImpl() {
	}

	// args cons
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	// setter
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
