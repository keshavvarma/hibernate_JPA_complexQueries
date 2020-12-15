/**
 * 
 */
package com.mystudy.OneToOneForeignKeyAssociation.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneForeignKeyAssociation.model.Department;
import com.mystudy.OneToOneForeignKeyAssociation.model.Staff;
import com.mystudy.repository.DepartmentRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class DepartmentDao{
	@Autowired
	DepartmentRepository departmentRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Department save(Department department) {
		Staff staff = entityManager.find(Staff.class, department.getStaff().getStaffId());
		department.setStaff(staff);
		return departmentRepository.save(department);
	}
	
	public Department findById(long departmentId) {
		Optional<Department> optional = departmentRepository.findById(departmentId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Transactional
	public Department updateDepartment(Department department, long staffId) {
		Staff staff = entityManager.find(Staff.class, staffId);
		department.setStaff(staff);
		return departmentRepository.save(department);
	}
	
	public Department updateDepartmentHead(long departmentId, long staffId) {
		Department department = entityManager.find(Department.class, departmentId);
		Staff staff = entityManager.find(Staff.class, staffId);
		department.setStaff(staff);
		return departmentRepository.save(department);
	}
	
	
}
