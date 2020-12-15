/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToOneSharedPrimaryKey.dao.EmployeeDao;
import com.mystudy.OneToOneSharedPrimaryKey.model.Employee;

/**
 * @author Keshav
 *
 */
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	public List<Employee> findAllEmployeeWithAccountDetails() {
		return employeeDao.findAll();
	}

	public Employee find(long employeeId) {
		return employeeDao.find(employeeId);
	}
}
