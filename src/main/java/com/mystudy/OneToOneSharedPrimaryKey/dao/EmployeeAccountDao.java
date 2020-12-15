/**
 * 
 */
package com.mystudy.OneToOneSharedPrimaryKey.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneSharedPrimaryKey.model.Account;
import com.mystudy.OneToOneSharedPrimaryKey.model.Employee;
import com.mystudy.repository.EmployeeAccountRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class EmployeeAccountDao{
	@Autowired
	EmployeeAccountRepository employeeAccountRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * @Transactional annotation is used to perform the query in single transaction.
	 * Fetch the related employee entity and set it to account object for foreign key
	 */
	@Transactional
	public Account save(Account account) {
		Employee employee = entityManager.find(Employee.class, account.getEmployee().getEmployeeId());
		account.setEmployee(employee);
		entityManager.persist(account);
		return account;
	}
	
	public Account findByEmployeeId(long employeeId) {
		Optional<Account> optional = employeeAccountRepository.findById(employeeId);
		if(optional.isPresent()) {
			//optional.get().setEmployee(null);
			return optional.get();
		}
		return null;
	}

	public List<Account> findAll() {
		return employeeAccountRepository.findAll();
	}
	
	public List<Account> findEmployeeAndAccountDetials() {
		return entityManager.createQuery("select a from Account a inner join fetch a.employee e", Account.class).getResultList();
		//return employeeAccountRepository.findAll();
	}
}
