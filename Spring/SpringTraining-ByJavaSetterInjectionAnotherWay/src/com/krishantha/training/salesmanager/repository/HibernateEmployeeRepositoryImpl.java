package com.krishantha.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.krishantha.training.salesmanager.model.Employee;
@Repository("AnyName")
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
