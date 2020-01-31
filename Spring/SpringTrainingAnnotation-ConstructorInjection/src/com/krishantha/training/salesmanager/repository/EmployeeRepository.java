package com.krishantha.training.salesmanager.repository;

import java.util.List;

import com.krishantha.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	public abstract List<Employee> getAllEmployees();

}