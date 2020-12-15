/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToOneSharedPrimaryKey.dao.EmployeeAccountDao;
import com.mystudy.OneToOneSharedPrimaryKey.model.Account;

/**
 * @author Keshav
 *
 */
@Service
public class EmployeeAccountService {
	@Autowired
	EmployeeAccountDao employeeAccountDao;
	
	public Account save(Account account) {
		return employeeAccountDao.save(account);
	}
	
	public Account getAccountByEmployeeId(long employeeId) {
		return employeeAccountDao.findByEmployeeId(employeeId);
	}

	public List<Account> findAll() {
		return employeeAccountDao.findAll();
	}
	
	
	public List<Account> findEmployeeAndAccountDetials() {
		return employeeAccountDao.findEmployeeAndAccountDetials();
	}
	
}
