/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.model.Student;

/**
 * @author om
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
