package com.krishantha.training.salesmanager.service;

import java.util.List;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	//Meka one na xml walin api meka hadena eka automate karanawa
	// EmployeeRepository employeeRepository= new HibernateEmployeeRepositoryImpl();

	public EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
