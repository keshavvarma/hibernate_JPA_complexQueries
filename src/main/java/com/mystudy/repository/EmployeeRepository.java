/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.OneToOneSharedPrimaryKey.model.Employee;

/**
 * @author Keshav
 *
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
