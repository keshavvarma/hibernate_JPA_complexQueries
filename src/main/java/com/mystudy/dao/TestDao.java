/**
 * 
 */
package com.mystudy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.model.Test;
import com.mystudy.repository.TestRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class TestDao {
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	TestRepository testRepository;
	
	public List<Test> findAllTests(){
		return entityManager.createQuery("Select t from Test t where deletedBy is null", Test.class ).getResultList();
	}
	
}
