package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.manager.EmployeeManager;
import com.example.demo.model.Employee;
import com.example.demo.model.GenderSalary;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeManager manager;

	@GetMapping(produces="application/json")
	public List<Employee> getAllEmployees(){
//		return manager.findAll(1,5);
		return manager.findAll();
	}
	
	@GetMapping(path="/averagesalaries", produces="application/json")
	public List<GenderSalary> getEmployeesByAverageSalary(){
		return manager.fetchSalaryDataByGender();
	}

	@GetMapping(path="/{id}", produces="application/json")
	public Employee getEmployee(@PathVariable int id){
		return manager.findById(id);
	}
	
	@PostMapping(consumes="application/json", produces="application/json")
	public Employee create(@RequestBody Employee e){
		return manager.create(e);
	}

}
