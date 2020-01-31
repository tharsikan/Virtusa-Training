package com.krishantha.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepository employeeRepository;

	
	 public EmployeeServiceImpl() {
		 System.out.println("Constructor Called");	
	 }

	// Me error eka enawa setter injection eka gahanawanam args constructor ba
	// No default constructor found; nested exception is
	// java.lang.NoSuchMethodException:
	// public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	// this.employeeRepository = employeeRepository;
	// }

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter Called");	
		this.employeeRepository = employeeRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
}
