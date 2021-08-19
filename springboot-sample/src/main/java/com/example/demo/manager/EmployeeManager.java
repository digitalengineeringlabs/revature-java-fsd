package com.example.demo.manager;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.GenderSalary;

public interface EmployeeManager {

	List<Employee> findAll();
	
	List<Employee> findAll(int startIndex, int count);

	Employee findById(int id);
	
	List<GenderSalary> fetchSalaryDataByGender();

	Employee create(Employee e);

}
