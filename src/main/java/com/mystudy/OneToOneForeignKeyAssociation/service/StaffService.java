/**
 * 
 */
package com.mystudy.OneToOneForeignKeyAssociation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToOneForeignKeyAssociation.dao.StaffDao;
import com.mystudy.OneToOneForeignKeyAssociation.model.Staff;

/**
 * @author Keshav
 *
 */
@Service
public class StaffService {
	@Autowired
	StaffDao staffDao;
	
	public Staff save(Staff staff) {
		return staffDao.save(staff);
	}

	public Staff find(long staffId) {
		return staffDao.findById(staffId);
	}
	
}
