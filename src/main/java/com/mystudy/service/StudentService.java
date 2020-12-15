/**
 * 
 */
package com.mystudy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.mystudy.dao.StudentDao;
import com.mystudy.model.Student;
import com.mystudy.model.StudentSupervisorView;
import com.mystudy.util.PagableImpl;

/**
 * @author Keshav
 *
 */
@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	int pageLength = 50;
	
	public Student save(Student student) {
		return studentDao.save(student);
	}

	public List<StudentSupervisorView> fetchStudentAndSupervisor() {
		return studentDao.fetchStudentAndSupervisor();
	}

	public boolean save1000Records() {
		List<Student> students = new ArrayList<Student>();
		int totalRecords = 500, processed = 0;
		Student student = null;
		LocalDate dob = LocalDate.now();
		while(processed != totalRecords) {
			processed++;
			student = new Student();
			student.setName("Student " + processed);
			student.setAge(20);
			student.setDob(dob);
			students.add(student);
		}
		studentDao.save1000Records(students);
		return true;
	}

	public List<Student> findRecords(int pageNumber, int pageLength, PagableImpl pagable) {
		long totalRecords = studentDao.findRecordsCount();
		//List<Student> list = studentDao.findRecords(pageNumber, pageLength);
		List<Student> list = studentDao.findRecordsWithCritriaQuery(pageNumber, pageLength);
		pagable.setDetails(pageNumber, pageLength, totalRecords, list.size());
		return list;
	}
	
	public Page<Student> findWithPageable1(Pageable pageable) throws Exception{
		Class<Student> sClass = Student.class;
		Iterator<Order> iterator = pageable.getSort().iterator();
		while(iterator.hasNext()) {
			try {
				sClass.getField(iterator.next().getProperty());
			} catch (NoSuchFieldException | SecurityException e) {
				throw new Exception("NoSuchFieldException : " + e.getMessage());
			}
		}
		System.out.println("is sorted :" + pageable.getSort().isSorted());
		return studentDao.findWithPageable1(pageable);
	}

	public List<Student> findRecordsWithCriteria() {
		return studentDao.findRecordsWithCriteria();
	}

	public List<Student> queryByMethodName() {
		return studentDao.queryByMethodName();
	}
}
