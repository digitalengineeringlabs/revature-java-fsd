package com.example.demo.manager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import com.example.demo.model.GenderSalary;

@Service
@Transactional// all methods in this class will utilize the tx manager and contextual sessions
public class EmployeeManagerImpl implements EmployeeManager {
	
	@Autowired
	private EmployeeDao dao;

	@Override
	@Transactional(readOnly=true, propagation=Propagation.NEVER)
	public List<Employee> findAll() {

//		return dao.findByGenderAndAge("M",31);
//		return dao.getEmployeesWithMedian(40000,50000);
		return dao.getSeniorEmployees(30);
		
//		return StreamSupport.stream(dao.findAll().spliterator(), false)
//				.collect(Collectors.toList());
	}
	
	@Override
	public List<Employee> findAll(int startIndex, int count) {
		
		Pageable pageable = PageRequest.of(startIndex, count);
		
		return StreamSupport.stream(dao.findAll(pageable).spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Employee findById(int id) {
		return dao.findById(Integer.valueOf(id)).get();
	}

	@Override
	public List<GenderSalary> fetchSalaryDataByGender() {
		
		return dao.fetchSalaryDataByGender();
	}

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE, 
		rollbackFor={ConstraintViolationException.class}, 
		propagation=Propagation.REQUIRES_NEW) // override when the transaction should rollback.
	public Employee create(Employee e) {
		return dao.save(e);
	}

}
