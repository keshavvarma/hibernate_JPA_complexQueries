/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mystudy.OneToOneSharedPrimaryKey.model.Account;

/**
 * @author Keshav
 *
 */

public interface EmployeeAccountRepository extends JpaRepository<Account, Long>{
	@Query("select a from Account a where a.id = ?1")
	public Account getAccountByEmployeeId(long employeeId);
}
