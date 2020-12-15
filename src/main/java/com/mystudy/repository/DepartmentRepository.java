/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.OneToOneForeignKeyAssociation.model.Department;

/**
 * @author Keshav
 *
 */

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
