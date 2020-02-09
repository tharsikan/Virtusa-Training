package com.ishan.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.app.model.Address;
import com.ishan.app.model.Employee;
import com.ishan.app.model.Telephone;
import com.ishan.app.repository.EmployeeRepository;
import com.ishan.app.service.EmployeeService;

//Declare this class as Rest controller class
@RestController
@RequestMapping("service")
public class EmployeeController {

	// Service bean has been made so autowire it to out reference
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("test")
	public Employee test() {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setName("ishan");
		employee.setMarks("99");

		Address adress = new Address();
		adress.setCity("Ragama");
		employee.setAddress(adress);

		Telephone telephone = new Telephone();
		telephone.setNo(11989);
		telephone.setEmployee(employee);

//		Telephone telephone1 = new Telephone();
//		telephone1.setNo(115258989);
//		telephone1.setEmployee(employee);
//
//		List<Telephone> list = new ArrayList<>();
//		list.add(telephone);
//		list.add(telephone1);
//
//		employee.setTelephones(list);
		// employee.addTelephones(telephone);
//		employee.addTelephones(telephone1);

		return employee;
	}

	// findThe selected element and return so this is done by JpaRepository find
	// method
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		if (id == 0) {
			Employee employee = new Employee();
			employee.setId(10);
			employee.setName("ishan");
			return employee;
		} else
			return employeeService.findById(id);

	}

	// Delete And check if the cascading works both employee and adress must be
	// deleted
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	@Transactional
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee getEmployees(@RequestBody Employee e) {

		Employee eee = employeeService.save(e);
		return eee;
	}
}
