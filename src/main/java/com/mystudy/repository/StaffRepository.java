/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.OneToOneForeignKeyAssociation.model.Staff;

/**
 * @author Keshav
 *
 */

public interface StaffRepository extends JpaRepository<Staff, Long>{

}
