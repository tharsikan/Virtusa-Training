package com.krishantha.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	// Meka wenas unata awulak yanne na setterMethod
	public EmployeeRepository employeeRepositoryB;

	// // no ars cons
	// public EmployeeServiceImpl() {
	// }
	//
	// // args cons
	// public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	// this.employeeRepository = employeeRepository;
	// }

	// setter eke Name Eka Thama Match karanne-Match by property name(setter Name) and Expecting Bean class name
	//you only need to have setter method with same exact name 
	public void setEmployeeRepositoryA(EmployeeRepository employeeRepository) {
		this.employeeRepositoryB = employeeRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepositoryB;
	}

	public List<Employee> getAllEmployees() {
		return employeeRepositoryB.getAllEmployees();
	}
}
