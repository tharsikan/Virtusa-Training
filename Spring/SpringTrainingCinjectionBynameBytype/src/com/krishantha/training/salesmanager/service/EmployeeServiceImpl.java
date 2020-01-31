package com.krishantha.training.salesmanager.service;

import java.util.List;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	//Meka one na xml walin api meka hadena eka automate karanawa
	// EmployeeRepository employeeRepository= new HibernateEmployeeRepositoryImpl();

	public EmployeeRepository employeeRepository;

	//by type ekata dammoth no args constructor ekak one
	public EmployeeServiceImpl() {
//		this.employeeRepository = employeeRepository;
// EmployeeRepository employeeRepository; dan meka init karanna kiyala nane
//eya xml eke employeeRepository bean compare karala thama wade karanne
	}
	
	//constructor method ekak haduwa uda kenawa initialize karanna
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	//setter ekak haduwa uda kenawa init karanna passe meka constructor injection
	//ekata danawa
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
