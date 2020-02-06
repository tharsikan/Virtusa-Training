package com.ishan.Test;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
public class Employee {
	String name;
	String location;

	public Employee(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee("Ishan", "PIliyandala kesbawa"));
		employees.add(new Employee("Nishan", "Gampaha kesbawa"));
		employees.add(new Employee("Kishan", "Ragama kesbawa"));
		employees.add(new Employee("Nishan", "PIliyandala kesbawa"));
		return employees;

	}
}