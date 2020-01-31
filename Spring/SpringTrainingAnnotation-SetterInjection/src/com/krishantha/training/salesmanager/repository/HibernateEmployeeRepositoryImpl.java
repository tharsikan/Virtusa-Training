package com.krishantha.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.krishantha.training.salesmanager.model.Employee;
//Meke name eka thama denne Application.java eke
//but meke one name ekak wenna ba EmployeeRepository-->employeeRepository
@Repository("employeeRepository")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee = new Employee();
		employee.setEmployeeName("Ishan");
		employee.setEmployeeLocation("Piliyandala");
		employees.add(employee);
		return employees;
	}
	

}
