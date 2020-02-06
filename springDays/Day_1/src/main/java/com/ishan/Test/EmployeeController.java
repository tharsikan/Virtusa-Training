package com.ishan.Test;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @RequestMapping("hello")
    public String greeting(){

        return "<h1>Hello hiiiiiiii ishaaaaan</h1>";
    }

	@RequestMapping("/employee")
	public List<Employee> getEmployees() {
		return Employee.getAllEmployees();
	}

}

