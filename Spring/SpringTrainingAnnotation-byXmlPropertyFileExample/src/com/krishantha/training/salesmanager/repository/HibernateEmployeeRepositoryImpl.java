package com.krishantha.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.krishantha.training.salesmanager.model.Employee;
//Meke name eka thama denne Application.java eke
//but meke one name ekak wenna ba EmployeeRepository-->employeeRepository

@Repository("employeeRepository")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
	@Value("${name}")
	private String name;
	@Value("${city}")
	private String city;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee = new Employee();
		employee.setEmployeeName(name);
		employee.setEmployeeLocation(city);
		employees.add(employee);
		return employees;
	}

}
