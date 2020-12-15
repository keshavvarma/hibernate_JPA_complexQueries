/**
 * 
 */
package com.mystudy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.model.Student;
import com.mystudy.repository.StudentRepository;

/**
 * @author om
 *
 */
@Repository
public class StudentDao {
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> findAllByTeamId(Long teamId){
		return entityManager.createQuery("Select s from Student s where s.team.teamId = " + teamId + " and deletedBy is null", Student.class ).getResultList();
	}
	
}
