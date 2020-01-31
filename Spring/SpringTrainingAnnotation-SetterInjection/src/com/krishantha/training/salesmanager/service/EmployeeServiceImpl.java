package com.krishantha.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepository employeeRepository;

	// No args constructor is needed to setter injection
	//(Meka explicit damme nathi unath enawane java wala default)
	// public EmployeeServiceImpl() {
	// }

	// Me error eka enawa setter injection eka gahanawanam args constructor ba
	// No default constructor found; nested exception is
	// java.lang.NoSuchMethodException:
	// public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	// this.employeeRepository = employeeRepository;
	// }

	@Autowired
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
