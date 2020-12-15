/**
 * 
 */
package com.mystudy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mystudy.model.Student;

/**
 * @author Keshav
 *
 */

public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query(value = "select s from Student s left join fetch s.team t"
			,countQuery = "select count(*) from Student s left outer join s.team"
			//,nativeQuery = true
			)
	public Page<Student> findAllWithPageable(Pageable pageable);
	
	public List<Student> findTop10ByOrderByStudentId();
	
	public List<Student> findByNameStartingWithAndDobLessThan(String name, LocalDate dob);
	
}
