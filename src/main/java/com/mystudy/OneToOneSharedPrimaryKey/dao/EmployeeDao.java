/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneSharedPrimaryKey.model.Employee;
import com.mystudy.repository.EmployeeRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class EmployeeDao{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee find(long employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException("Employee not found with employee id = " + employeeId);
		}
	}

	public List<Employee> findAllEmployeeWithAccountDetails() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	public List<Employee> findAll() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
}
