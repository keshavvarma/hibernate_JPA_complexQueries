/**
 * 
 */
package com.mystudy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.model.TestAssignment;
import com.mystudy.repository.TestAssignmentRepository;

/**
 * @author om
 *
 */
@Repository
public class TestAssignmentDao {
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	TestAssignmentRepository testAssignmentRepository;
	
	public List<TestAssignment> findAllByAssignedTestByTeamId(Long teamId){
		return entityManager.createQuery("Select t from TestAssignment t where t.testAssignmentId.teamId = " + teamId + " and deletedBy is null", TestAssignment.class ).getResultList();
	}
	
}
