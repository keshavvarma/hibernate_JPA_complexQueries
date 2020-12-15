/**
 * 
 */
package com.mystudy.OneToOneForeignKeyAssociation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToOneForeignKeyAssociation.dao.DepartmentDao;
import com.mystudy.OneToOneForeignKeyAssociation.model.Department;

/**
 * @author Keshav
 *
 */
@Service
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;
	
	public Department save(Department department) {
		return departmentDao.save(department);
	}

	public Department find(long departmentId) {
		return departmentDao.findById(departmentId);
	}
	
	public Department updateDepartmentHead(long departmentId, long staffId) {
		return departmentDao.updateDepartmentHead(departmentId, staffId);
	}
	
}
