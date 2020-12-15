/**
 * 
 */
package com.mystudy.OneToOneForeignKeyAssociation.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneForeignKeyAssociation.model.Staff;
import com.mystudy.repository.StaffRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class StaffDao{
	@Autowired
	StaffRepository staffRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	public Staff save(Staff staff) {
		return staffRepository.save(staff);
	}
	
	public Staff findById(long staffId) {
		Optional<Staff> optional = staffRepository.findById(staffId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
