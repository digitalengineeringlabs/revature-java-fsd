package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;
import com.example.demo.model.GenderSalary;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByGenderAndAge(String gender, int age);
	
	@Query(value="select e from Employee e where e.salary between :start and :end")
	public List<Employee> getEmployeesWithMedian(@Param("start") int start, @Param("end") int end);
	
	@Query(value="select * from employee where age > ?1",nativeQuery = true)
	public List<Employee> getSeniorEmployees(int limit);
	
	@Query("select e.gender as gender, AVG(e.salary) as average from Employee e group by e.gender")
	List<GenderSalary> fetchSalaryDataByGender();


}
